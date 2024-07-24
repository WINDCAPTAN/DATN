package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.MauSac;
import com.example.web_hshop.repository.MauSacRepository;
import com.example.web_hshop.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class MauSacServiceIMPL implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll(){
        return mauSacRepository.findAll();
    }
    @Override
    public  MauSac add(@Valid MauSac mauSac){
        return mauSacRepository.save(mauSac);
    }
    @Override
    public MauSac update(MauSac mauSac){
        return mauSacRepository.save(mauSac);
    }

    @Override
    public MauSac getById(Long id) {
        return mauSacRepository.findById(id).get();
    }

    @Override
    public boolean checkTenTrung(String ten) {
        return !mauSacRepository.findByTen(ten).isPresent();
    }

    @Override
    public Integer genMaTuDong() {
        String maStr = "";
        try {
            if (mauSacRepository.index() != null) {
                maStr = mauSacRepository.index().toString();
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
    public Optional<MauSac> findByTen(String ten) {
        return mauSacRepository.findByTen(ten);
    }

    @Override
    public Page<MauSac> search(String ten, Boolean trangThai, Pageable pageable) {
        return mauSacRepository.search(ten, trangThai, pageable);
    }

}
