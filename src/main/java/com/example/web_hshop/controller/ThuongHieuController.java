package com.example.web_hshop.controller;

import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.ThuongHieu;
import com.example.web_hshop.repository.ThuongHieuRepository;
import com.example.web_hshop.service.ThuongHieuService;
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
@RequestMapping("/thuong-hieu")
public class ThuongHieuController {

    @Autowired
    private ThuongHieuService thuongHieuService;

    @Autowired
    ThuongHieuRepository thuongHieuRepo;


    @GetMapping("")
    public String hienthi(Model model,
                          @RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ThuongHieu> pageTH;

        if (keyword.isEmpty()) {
            pageTH = thuongHieuService.findAll(pageable);
        } else {
            pageTH = thuongHieuRepo.findByTenContaining(keyword, pageable);
        }

        model.addAttribute("listTH", pageTH.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageTH.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("thuongHieu", new ThuongHieu());
        model.addAttribute("url", "/thuong-hieu"); // Add this line
        return "/category/thuonghieu/thuong-hieu";
    }

    @GetMapping("/dang-hoat-dong")
    public String hienThiDangHoatDong(Model model,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ThuongHieu> pageTH;
        if (keyword.isEmpty()) {
            pageTH = thuongHieuService.getAllDangHoatDong(pageable);
        } else {
            pageTH = thuongHieuRepo.findByTenContaining(keyword, pageable);
        }

        model.addAttribute("listTH", pageTH.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageTH.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("thuongHieu", new ThuongHieu());
        model.addAttribute("url", "/thuong-hieu/dang-hoat-dong"); // Add this line
        return "/category/thuonghieu/thuong-hieu";
    }

    @GetMapping("/ngung-hoat-dong")
    public String hienThiNgungHoatDong(Model model,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "") String keyword) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ThuongHieu> pageTH;

        if (keyword.isEmpty()) {
            pageTH = thuongHieuService.getAllNgungHoatDong(pageable);
        } else {
            pageTH = thuongHieuRepo.findByTenContaining(keyword, pageable);
        }

        model.addAttribute("listTH", pageTH.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", pageTH.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("thuongHieu", new ThuongHieu());
        model.addAttribute("url", "/thuong-hieu/ngung-hoat-dong"); // Add this line
        return "/category/thuonghieu/thuong-hieu";
    }


    @PostMapping("/add")
    public String add(@Valid
                      @ModelAttribute("thuongHieu") ThuongHieu thuongHieu,
                      BindingResult result,
                      Model model,
                      RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            model.addAttribute("checkModal", "modal");
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("listTH", thuongHieuService.findAll(Pageable.unpaged()));
            return "/category/thuonghieu/thuong-hieu";
        } else if (!thuongHieuService.checkTenTrung(thuongHieu.getTen())) {
            model.addAttribute("checkModal", "modal");
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("checkTenTrung", "Thương hiệu đã tồn tại");
            model.addAttribute("listTH", thuongHieuService.findAll(Pageable.unpaged()));
            return "/category/thuonghieu/thuong-hieu";
        } else {
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            thuongHieu.setNgayTao(new Date());
            thuongHieu.setNgaySua(new Date());
            thuongHieu.setTrangThai(true);
            thuongHieuService.save(thuongHieu);
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            return "redirect:/thuong-hieu";
        }
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(
            Model model,
            @PathVariable("id") Long id
    ) {

        ThuongHieu thuongHieu = thuongHieuService.getById(id);
        model.addAttribute("listTH", thuongHieuService.findAll(Pageable.unpaged()));
        model.addAttribute("thuongHieu", thuongHieu);
        return "/category/thuonghieu/update-thuonghieu";
    }
    @PostMapping("/update")
    public String update(@Valid
                         @ModelAttribute("thuongHieu") ThuongHieu thuongHieu,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {

            model.addAttribute("checkThongBao", "thaiBai");
            return "/category/thuonghieu/update-thuonghieu";
        } else if (!thuongHieuService.checkTenTrungSua(thuongHieu.getId(), thuongHieu.getTen())) {
            model.addAttribute("checkThongBao", "thaiBai");
            model.addAttribute("checkTenTrung", "Thương hiệu đã tồn tại");
            return "/category/thuonghieu/update-thuonghieu";
        } else {
            redirectAttributes.addFlashAttribute("checkThongBao", "thanhCong");
            ThuongHieu th = thuongHieuService.getById(thuongHieu.getId());
            thuongHieu.setNgayTao(th.getNgayTao());
            thuongHieu.setNgaySua(new Date());
            thuongHieuService.update(thuongHieu);
            return "redirect:/thuong-hieu";
        }
    }
}
