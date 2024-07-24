package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.TaiKhoan;
import com.example.web_hshop.repository.KhachHangRepository;

import com.example.web_hshop.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceIMPL implements KhachHangService {
    @Autowired
    KhachHangRepository repository;

    @Override
    public List<TaiKhoan> getAll() {

        return repository.fillAllKhachHang();
    }

    @Override
    public void addKhachLe() {
        repository.addKhachLe();
    }

    @Override
    public TaiKhoan findKhachLe() {
        return repository.findKhachLe();
    }

}
