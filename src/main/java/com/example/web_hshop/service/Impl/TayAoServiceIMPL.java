package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.entity.ThuongHieu;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.service.TayAoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TayAoServiceIMPL implements TayAoService {
    @Autowired
    private TayAoRepstory tayAoRepstory;


    @Override
    public Page<TayAo> findAll(Pageable pageable) {

//        Sort sort = Sort.by(Sort.Direction.DESC, "ngaySua");
        return tayAoRepstory.findAll(pageable);

    }
//    @Override
//    public Page<TayAo> getAllDangHoatDong(Pageable pageable) {
//        return tayAoRepstory.fillAllDangHoatDong(pageable);
//    }
//
//    @Override
//    public Page<ThuongHieu> getAllNgungHoatDong(Pageable pageable) {
//        return thuongHieuRepository.fillAllNgungHoatDong(pageable);
//    }
    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public TayAo save(TayAo tayAo) {

        return tayAoRepstory.save(tayAo);

    }

    @Override
    public boolean checkTenTrung(String ten) {

        for (TayAo ta : tayAoRepstory.findAll()) {
            if (ta.getTen().equalsIgnoreCase(ten)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean checkTenTrungSua(Long id, String ten) {

        for (TayAo ta : tayAoRepstory.findAll()) {
            if (ta.getTen().equalsIgnoreCase(ten)) {
                if (!ta.getId().equals(id)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public TayAo update(TayAo tayAo) {

        return tayAoRepstory.save(tayAo);

    }

    @Override
    public TayAo getById(Long id) {

        return tayAoRepstory.findById(id).get();

    }
}
