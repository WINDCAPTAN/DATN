package com.example.web_hshop.controller;

import com.example.web_hshop.entity.ThuongHieu;
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
public class BanHangCotroller {

    @GetMapping("/admin")
    public String hienThi() {
        return "index";
    }


}
