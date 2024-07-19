package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.repository.ChatLieuRepository;
import com.example.web_hshop.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLieuServiceIMPL implements ChatLieuService {

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Override
    public List<ChatLieu> getAll(){return chatLieuRepository.findAll();
    }
}
