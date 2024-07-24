package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.ThuongHieu;
import com.example.web_hshop.repository.ThuongHieuRepository;
import com.example.web_hshop.service.ThuongHieuService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuServiceIMPL implements ThuongHieuService {


    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    @Override
    public Page<ThuongHieu> findAll(Pageable pageable) {

//        Sort sort = Sort.by(Sort.Direction.DESC, "ngaySua");
        return thuongHieuRepository.findAll(pageable);

    }
    @Override
    public Page<ThuongHieu> getAllDangHoatDong(Pageable pageable) {
        return thuongHieuRepository.fillAllDangHoatDong(pageable);
    }

    @Override
    public Page<ThuongHieu> getAllNgungHoatDong(Pageable pageable) {
        return thuongHieuRepository.fillAllNgungHoatDong(pageable);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public ThuongHieu save(ThuongHieu thuongHieu) {

        return thuongHieuRepository.save(thuongHieu);

    }

    @Override
    public boolean checkTenTrung(String ten) {

        for (ThuongHieu sp : thuongHieuRepository.findAll()) {
            if (sp.getTen().equalsIgnoreCase(ten)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean checkTenTrungSua(Long id, String ten) {

        for (ThuongHieu sp : thuongHieuRepository.findAll()) {
            if (sp.getTen().equalsIgnoreCase(ten)) {
                if (!sp.getId().equals(id)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ThuongHieu update(ThuongHieu thuongHieu) {

        return thuongHieuRepository.save(thuongHieu);

    }

    @Override
    public ThuongHieu getById(Long id) {

        return thuongHieuRepository.findById(id).get();

    }
}
