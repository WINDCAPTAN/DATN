package com.example.web_hshop.service.impl;

import com.example.web_hshop.entity.ThuongHieu;
import com.example.web_hshop.repository.ThuongHieuRepository;
import com.example.web_hshop.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuServiceIMPL implements ThuongHieuService {

    @Autowired
    private ThuongHieuRepository thuongHieuRepo;

    @Override
    public List<ThuongHieu> getAll() {
        return thuongHieuRepo.findAll();
    }

    @Override
    public ThuongHieu add(ThuongHieu thuongHieu) {
        return thuongHieuRepo.save(thuongHieu);
    }

    @Override
    public ThuongHieu update(ThuongHieu thuongHieu) {
        return thuongHieuRepo.save(thuongHieu);
    }

    @Override
    public void delete(Long id) {
        thuongHieuRepo.deleteById(id);
    }

    @Override
    public ThuongHieu getById(Long id) {
        return thuongHieuRepo.findById(id).get();
    }
}
