package com.example.web_hshop.service;

import com.example.web_hshop.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    SanPham add(SanPham sanPham);

    SanPham update(SanPham sanPham);

    void delete(Long id);

    SanPham getById(Long id);
}
