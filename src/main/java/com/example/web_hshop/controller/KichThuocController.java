package com.example.web_hshop.controller;

import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.MauSac;
import com.example.web_hshop.repository.KichCoRepository;
import com.example.web_hshop.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;

@Controller
public class KichThuocController {

    @Autowired
    private KichCoService kichCoService;

//    @GetMapping("/kich-thuoc")
//    public String hienThi(Model model){
//        model.addAttribute("listKT",kichCoService.getAll());
//        model.addAttribute("kichThuoc",new KichCo());
//        return "category/kichthuoc/kichthuoc";
//    }
@GetMapping("/kich-thuoc")
public String hienThiKT(Model model,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(required = false) String ten,
                            @RequestParam(required = false) Boolean trangThai) {
    Pageable pageable = PageRequest.of(page, 3);
    Page<KichCo> pageKT = kichCoService.search(ten, trangThai, pageable);
    model.addAttribute("listKT", pageKT.getContent());
    model.addAttribute("tongSoTrang", pageKT.getTotalPages());
    model.addAttribute("trangHienTai", page);
    model.addAttribute("ten", ten);
    model.addAttribute("trangThai", trangThai);
    model.addAttribute("kichThuoc", new KichCo());
    return "category/kichthuoc/kichthuoc";
}
    @PostMapping("/kich-thuoc/add")
    public String addKT( @ModelAttribute("kichThuoc") KichCo kichCo) {
        kichCo.setMa("CL" + kichCoService.genMaTuDong());
        kichCo.setTrangThai(true);
        kichCo.setNgayTao(Date.valueOf(LocalDate.now()));
        kichCoService.add(kichCo);
        return "redirect:/kich-thuoc";
    }
    @GetMapping("/kich-thuoc/view-update/{id}")
    public String viewUP(@PathVariable("id") Long id, Model model) {
        KichCo kichCo = kichCoService.getById(id);
        model.addAttribute("listUD", kichCo);
        return "category/kichthuoc/kichthuoc-update";
    }

    @PostMapping("/kich-thuoc/update")
    public String updateKT(@ModelAttribute("kichThuoc") KichCo kichCo) {
        KichCo kt = kichCoService.getById(kichCo.getId());
        kichCo.setNgayTao(kt.getNgayTao());
        kichCo.setNgaySua(Date.valueOf(LocalDate.now()));
        kichCoService.add(kichCo);
        return "redirect:/kich-thuoc";
    }
}
