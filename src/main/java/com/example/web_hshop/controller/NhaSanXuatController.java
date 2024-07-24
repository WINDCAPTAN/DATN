package com.example.web_hshop.controller;

import com.example.web_hshop.entity.NhaSX;
import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.NhaSXRepository;
import com.example.web_hshop.service.NhaSXService;
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
@RequestMapping("/nha-san-xuat")
public class NhaSanXuatController {

    @Autowired
    private NhaSXService nhaSXService;

    @Autowired
    NhaSXRepository nhaSXRepository;
    @GetMapping("")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<NhaSX> pageNSX;

        if (keyword.isEmpty()) {
            pageNSX = nhaSXService.findAll(pageable);
        } else {
            pageNSX = nhaSXRepository.findByTenContaining(keyword, pageable);
        }

        model.addAttribute("listNSX", pageNSX.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageNSX.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("nhaSX", new NhaSX());
        model.addAttribute("url", "/nha-san-xuat");
        return "/category/nhasanxuat/nha-san-xuat";
    }

    @PostMapping("/add")
    public String add(@Valid
                      @ModelAttribute("nhaSX") NhaSX nhaSX,
                      BindingResult result,
                      Model model,
                      RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("checkModal", "modal");
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("listNSX", nhaSXService.findAll(Pageable.unpaged()));
            return "/category/nhasanxuat/nha-san-xuat";
        } else if (!nhaSXService.checkTenTrung(nhaSX.getTen())) {
            model.addAttribute("checkModal", "modal");
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("checkTenTrung", "Nhasx đã tồn tại");
            model.addAttribute("listNSX", nhaSXService.findAll(Pageable.unpaged()));
            return "/category/nhasanxuat/nha-san-xuat";
        } else {
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            nhaSX.setNgayTao(new Date());
            nhaSX.setTrangThai(true);
            nhaSXService.save(nhaSX);
            return "redirect:/nha-san-xuat";
        }
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(
            Model model,
            @PathVariable("id") Long id
    ) {
        NhaSX nhaSX = nhaSXService.getById(id);
        model.addAttribute("listNSX", nhaSXService.findAll(Pageable.unpaged()));
        model.addAttribute("nhaSX", nhaSX);
        return "/category/nhasanxuat/update-nhasanxuat";
    }

    @PostMapping("/update")
    public String update(@Valid
                         @ModelAttribute("nhaSX") NhaSX nhaSX,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("checkThongBao", "thaiBai");
            return "/category/nhasanxuat/update-nhasanxuat";
        } else if (!nhaSXService.checkTenTrungSua(nhaSX.getId(), nhaSX.getTen())) {
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("checkTenTrung", "Nhasx đã tồn tại");
            return "/category/nhasanxuat/update-nhasanxuat";
        } else {
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            NhaSX nsx = nhaSXService.getById(nhaSX.getId());
            nhaSX.setNgayTao(nsx.getNgayTao());
            nhaSXService.update(nhaSX);
            return "redirect:/nha-san-xuat";
        }
    }
}
