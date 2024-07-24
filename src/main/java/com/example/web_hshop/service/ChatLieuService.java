package com.example.web_hshop.service;

import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.entity.SanPham;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAll();
    ChatLieu getById(Long id);
}
