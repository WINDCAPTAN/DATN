package com.example.web_hshop.service;

import com.example.web_hshop.entity.HoaDon;

import java.util.List;

public interface HoaDonService {
    List<HoaDon> findAll();
    List<HoaDon> find5ByTrangThai(Integer trangThai);

    HoaDon findById(Long id);

    void deleteById(Long id);

    void saveOrUpdate(HoaDon hoaDon);

    Integer countHoaDonTreo();
}
