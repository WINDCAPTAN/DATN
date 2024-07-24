package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.repository.ChatLieuRepository;
import com.example.web_hshop.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceIMPL implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAll() {
        return chatLieuRepository.findAll();
    }

    @Override
    public ChatLieu add(ChatLieu chatLieu) {
        return chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu update(ChatLieu chatLieu) {
        return chatLieuRepository.save(chatLieu);
    }

    @Override
    public ChatLieu getById(Long id) {
        return chatLieuRepository.findById(id).get();
    }

    @Override
    public Integer genMaTuDong() {
        String maStr = "";
        try {
            if (chatLieuRepository.index() != null) {
                maStr = chatLieuRepository.index().toString();
            } else {
                maStr = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (maStr == null) {
            maStr = "0";
            int ma = Integer.parseInt(maStr);
            return ++ma;
        }
        int ma = Integer.parseInt(maStr);
        return ++ma;
    }

    @Override
    public Page<ChatLieu> search(String ten, Boolean trangThai, Pageable pageable) {
        return chatLieuRepository.search(ten,trangThai,pageable);
    }

}
