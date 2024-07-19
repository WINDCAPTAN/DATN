package com.example.web_hshop.service;

import com.example.web_hshop.entity.SanPham;

import java.util.List;

public interface SanPhamService {
    List<SanPham> getAll();
    SanPham getById(Long id);
}
