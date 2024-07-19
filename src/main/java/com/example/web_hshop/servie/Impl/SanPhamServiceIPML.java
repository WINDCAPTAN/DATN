package com.example.web_hshop.servie.Impl;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.SanPhamRepository;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.servie.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceIPML implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;


    @Override
    public List<SanPham> getAll(){
        return sanPhamRepository.findAll();
    }

    @Override
    public SanPham getById(Long id) {

        return sanPhamRepository.findById(id).get();

    }
}
