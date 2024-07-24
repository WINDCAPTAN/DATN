package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.HoaDonChiTiet;
import com.example.web_hshop.repository.HoaDonChiTietRepository;
import com.example.web_hshop.repository.HoaDonRepository;
import com.example.web_hshop.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietServiceIMPL implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Override
    public List<HoaDonChiTiet> findAll() {
        return hoaDonChiTietRepository.findAll();
    }

    @Override
    public HoaDonChiTiet findById(Long id) {
        return hoaDonChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        hoaDonChiTietRepository.deleteById(id);
    }

    @Override
    public void saveOrUpdate(HoaDonChiTiet hoaDonChiTiet) {
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }
}
