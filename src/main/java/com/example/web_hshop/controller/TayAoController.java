package com.example.web_hshop.controller;

import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.service.TayAoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Date;

@Controller
@RequestMapping("/tay-ao")
public class TayAoController {
    @Autowired
    private TayAoService tayAoService;
    @Autowired
    private TayAoRepstory tayAoRepstory;

    @GetMapping("")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<TayAo> pageTA;

        if (keyword.isEmpty()) {
            pageTA = tayAoService.findAll(pageable);
        } else {
            pageTA = tayAoRepstory.findByTenContaining(keyword, pageable);
        }

        model.addAttribute("listTA", pageTA.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageTA.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("tayAo", new TayAo());
        model.addAttribute("url", "/tay-ao");
        return "/category/tayao/tay-ao";
    }

    @PostMapping("/add")
    public String add(@Valid
                      @ModelAttribute("tayao") TayAo tayAo,
                      BindingResult result,
                      Model model,
                      RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("checkModal", "modal");
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("listTA", tayAoService.findAll(Pageable.unpaged()));
            return "/category/tayao/tay-ao";
        } else if (!tayAoService.checkTenTrung(tayAo.getTen())) {
            model.addAttribute("checkModal", "modal");
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("checkTenTrung", "Tay áo đã tồn tại");
            model.addAttribute("listTA", tayAoService.findAll(Pageable.unpaged()));
            return "/category/tayao/tay-ao";
        } else {
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            tayAo.setNgayTao(new Date());
            tayAo.setNgaySua(new Date());
            tayAo.setTrangThai(true);
            tayAoService.save(tayAo);
            return "redirect:/tay-ao";
        }
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(
            Model model,
            @PathVariable("id") Long id
    ) {
        TayAo tayAo = tayAoService.getById(id);
        model.addAttribute("listTA", tayAoService.findAll(Pageable.unpaged()));
        model.addAttribute("tayAo", tayAo);
        return "/category/tayao/update-tayao";
    }

    @PostMapping("/update")
    public String update(@Valid
                         @ModelAttribute("tayAo") TayAo tayAo,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("checkThongBao", "thaiBai");
            return "/category/tayao/update-tayao";
        } else if (!tayAoService.checkTenTrungSua(tayAo.getId(), tayAo.getTen())) {
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("checkTenTrung", "Tay áo đã tồn tại");
            return "/category/tayao/update-tayao";
        } else {
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            TayAo ta = tayAoService.getById(tayAo.getId());
            tayAo.setNgayTao(ta.getNgayTao());
            tayAo.setNgaySua(new Date());
            tayAoService.update(tayAo);
            return "redirect:/tay-ao";
        }
    }
}
