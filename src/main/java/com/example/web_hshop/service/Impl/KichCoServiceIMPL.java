package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.MauSac;
import com.example.web_hshop.repository.KichCoRepository;
import com.example.web_hshop.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichCoServiceIMPL implements KichCoService {
    @Autowired
    private KichCoRepository kichCoRepository;

    @Override
    public List<KichCo> getAll(){
        return kichCoRepository.findAll();
    }

    @Override
    public KichCo add(KichCo kichCo) {
        return kichCoRepository.save(kichCo);
    }

    @Override
    public KichCo update(KichCo kichCo) {
        return kichCoRepository.save(kichCo);
    }

    @Override
    public KichCo getById(Long id) {
        return kichCoRepository.findById(id).get();
    }

    @Override
    public Integer genMaTuDong() {
        String maStr = "";
        try {
            if (kichCoRepository.index() != null) {
                maStr = kichCoRepository.index().toString();
            } else {
                maStr = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (maStr == null) {
            maStr = "0";
            int ma = Integer.parseInt(maStr);
            return ++ma;
        }
        int ma = Integer.parseInt(maStr);
        return ++ma;
    }

    @Override
    public Page<KichCo> search(String ten, Boolean trangThai, Pageable pageable) {
        return kichCoRepository.search(ten, trangThai, pageable);
    }

}
