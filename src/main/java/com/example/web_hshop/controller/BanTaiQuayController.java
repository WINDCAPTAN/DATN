package com.example.web_hshop.controller;

import com.example.web_hshop.repository.ChatLieuRepository;
import com.example.web_hshop.repository.KichThuocRepository;
import com.example.web_hshop.repository.MauSacRepository;
import com.example.web_hshop.repository.SanPhamChiTietRepository;
import com.example.web_hshop.repository.SanPhamRepository;
import com.example.web_hshop.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BanTaiQuayController {

    @GetMapping("/ban-hang")
    public String banHang(Model model){
        model.addAttribute("th",thuongHieurepo.findAll());
        model.addAttribute("sp",sanPhamrepo.findAll());
        model.addAttribute("spct", sanPhamCTrepo.findAll());
        model.addAttribute("ms", mauSacRepository.findAll());
        model.addAttribute("kv", kichThuocrepo.findAll());
        model.addAttribute("cl", chatLieurepo.findAll());
        return "category/bantaiquay";
    }
    @Autowired
    ChatLieuRepository chatLieurepo;

    @Autowired
    KichThuocRepository kichThuocrepo;

    @Autowired
    MauSacRepository mauSacRepository;

    @Autowired
    SanPhamChiTietRepository sanPhamCTrepo;

    @Autowired
    SanPhamRepository sanPhamrepo;

    @Autowired
    ThuongHieuRepository thuongHieurepo;


}
