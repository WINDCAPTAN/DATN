package com.example.web_hshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BanHangCotroller {
// test

    @GetMapping("/admin")
    public String hienThi(){
        return "index";
    }



}
