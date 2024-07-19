package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.NhaSX;
import com.example.web_hshop.repository.NhaSXRepository;
import com.example.web_hshop.service.NhaSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaSXServiceIMPL implements NhaSXService {

    @Autowired
    private NhaSXRepository nhaSXRepo;

    @Override
    public List<NhaSX> getAll() {
        return nhaSXRepo.findAll();
    }

    @Override
    public NhaSX add(NhaSX nhaSX) {
        return nhaSXRepo.save(nhaSX);
    }

    @Override
    public NhaSX update(NhaSX nhaSX) {
        return nhaSXRepo.save(nhaSX);
    }

    @Override
    public void delete(Long id) {
        nhaSXRepo.deleteById(id);
    }

    @Override
    public NhaSX getById(Long id) {
        return nhaSXRepo.findById(id).get();
    }
}
