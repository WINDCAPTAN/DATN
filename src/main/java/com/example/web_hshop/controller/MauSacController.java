package com.example.web_hshop.controller;

import com.example.web_hshop.entity.MauSac;
import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.repository.MauSacRepository;
import com.example.web_hshop.service.MauSacService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @GetMapping("/mau-sac")
    public String hienThiMauSac(Model model,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(required = false) String ten,
                                @RequestParam(required = false) Boolean trangThai) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<MauSac> pageMS = mauSacService.search(ten, trangThai, pageable);
        model.addAttribute("listMS", pageMS.getContent());
        model.addAttribute("tongSoTrang", pageMS.getTotalPages());
        model.addAttribute("trangHienTai", page);
        model.addAttribute("ten", ten);
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("mauSac", new MauSac());
        return "category/mausac/mausac";
    }

    @PostMapping("/mau-sac/add")
    public String addMS(@Valid @ModelAttribute("mauSac") MauSac mauSac) {
        mauSac.setMa("MS" + mauSacService.genMaTuDong());
        mauSac.setTrangThai(true);
        mauSac.setNgayTao(Date.valueOf(LocalDate.now()));
        mauSacService.add(mauSac);
        return "redirect:/mau-sac";
    }

    @GetMapping("/mau-sac/view-update/{id}")
    public String viewUP(@PathVariable("id") Long id, Model model) {
        MauSac mauSac = mauSacService.getById(id);
        model.addAttribute("listUD", mauSac);
        return "category/mausac/mausac-update";
    }

    @PostMapping("/mau-sac/update")
    public String updateSP(@ModelAttribute("mauSac") MauSac mauSac) {
        MauSac ms = mauSacService.getById(mauSac.getId());
        mauSac.setNgayTao(ms.getNgayTao());
        mauSac.setNgaySua(Date.valueOf(LocalDate.now()));
        mauSacService.add(mauSac);
        return "redirect:/mau-sac ";
    }
}
