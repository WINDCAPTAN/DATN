package com.example.web_hshop.service;

import com.example.web_hshop.entity.HoaDonChiTiet;

import java.util.List;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> findAll();

    HoaDonChiTiet findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(HoaDonChiTiet hoaDonChiTiet);
}
