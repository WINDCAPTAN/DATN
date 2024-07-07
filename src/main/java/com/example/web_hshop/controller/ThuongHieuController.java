package com.example.web_hshop.controller;

import com.example.web_hshop.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThuongHieuController {

    @Autowired
    private ThuongHieuRepository thuongHieuRepo;

    @GetMapping("/thuong-hieu")
    public String hienThi(Model model){
        model.addAttribute("listTH",thuongHieuRepo.findAll());
        return "category/thuonghieu";
    }
}
