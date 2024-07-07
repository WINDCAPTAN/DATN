package com.example.web_hshop.repository;

import com.example.web_hshop.entity.ChatLieu;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatLieuRepository extends JpaRepository<ChatLieu,Long> {
    List<ChatLieu> findAllByOrderByNgayTaoDesc();
}
