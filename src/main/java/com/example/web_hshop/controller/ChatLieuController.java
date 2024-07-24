package com.example.web_hshop.controller;

import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.service.ChatLieuService;
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

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;

@Controller
public class ChatLieuController {
//test 12
    @Autowired
    private ChatLieuService chatLieuService;

    @GetMapping("/chat-lieu")
    public String hienThiCL(Model model,
                            @RequestParam(defaultValue = "0") int page,
                            @RequestParam(required = false) String ten,
                            @RequestParam(required = false) Boolean trangThai) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<ChatLieu> pageCL = chatLieuService.search(ten, trangThai, pageable);
        model.addAttribute("listCL", pageCL.getContent());
        model.addAttribute("tongSoTrang", pageCL.getTotalPages());
        model.addAttribute("trangHienTai", page);
        model.addAttribute("ten", ten);
        model.addAttribute("trangThai", trangThai);
        model.addAttribute("chatLieu", new ChatLieu());
        return "category/chatlieu/chatlieu";
    }

    @PostMapping("/chat-lieu/add")
    public String addMS(@ModelAttribute("chatLieu") ChatLieu chatLieu) {
        chatLieu.setMa("CL" + chatLieuService.genMaTuDong());
        chatLieu.setTrangThai(true);
        chatLieu.setNgayTao(Date.valueOf(LocalDate.now()));
        chatLieuService.add(chatLieu);
        return "redirect:/chat-lieu";
    }

    @GetMapping("/chat-lieu/view-update/{id}")
    public String viewUP(@PathVariable("id") Long id, Model model) {
        ChatLieu chatLieu = chatLieuService.getById(id);
        model.addAttribute("listUD", chatLieu);
        return "category/chatlieu/chatlieu-update";
    }

    @PostMapping("/chat-lieu/update")
    public String updateCL(@ModelAttribute("chatLieu") ChatLieu chatLieu) {
        ChatLieu chatLieu1 = chatLieuService.getById(chatLieu.getId());
        chatLieu.setNgayTao(chatLieu1.getNgayTao());
        chatLieu.setNgaySua(Date.valueOf(LocalDate.now()));
        chatLieuService.add(chatLieu);
        return "redirect:/chat-lieu ";
    }
}
