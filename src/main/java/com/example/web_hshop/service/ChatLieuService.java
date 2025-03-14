package com.example.web_hshop.service;

import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.entity.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.web_hshop.entity.SanPham;

import java.util.List;

public interface ChatLieuService {
    List<ChatLieu> getAll();
    ChatLieu add(ChatLieu chatLieu);
    ChatLieu update(ChatLieu chatLieu);

    Integer genMaTuDong();
    Page<ChatLieu> search(String ten, Boolean trangThai, Pageable pageable);
    ChatLieu getById(Long id);
}
