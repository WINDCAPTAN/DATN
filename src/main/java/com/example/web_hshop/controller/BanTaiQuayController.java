package com.example.web_hshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BanTaiQuayController {

    @GetMapping("/ban-hang")
    public String banHang(){
        return "category/bantaiquay";
    }
}
