package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.repository.SanPhamRepository;
import com.example.web_hshop.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceIMPL implements SanPhamService {

    @Autowired
    private SanPhamRepository sanPhamRepo;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepo.findAll();
    }

    @Override
    public SanPham add(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }

    @Override
    public void delete(Long id) {
        sanPhamRepo.deleteById(id);
    }

    @Override
    public SanPham getById(Long id) {
        return sanPhamRepo.findById(id).get();
    }
}
