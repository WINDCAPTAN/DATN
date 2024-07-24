package com.example.web_hshop.service;

import com.example.web_hshop.entity.NhaSX;
import com.example.web_hshop.entity.TayAo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NhaSXService {
    Page<NhaSX> findAll(Pageable pageable);

//    Page<TayAo> getAllDangHoatDong(Pageable pageable);
//
//    Page<TayAo> getAllNgungHoatDong(Pageable pageable);

    void deleteById(Long id);

    NhaSX save(NhaSX nhaSX);

    boolean checkTenTrung(String ten);

    boolean checkTenTrungSua(Long id, String ten);

    NhaSX update(NhaSX nhaSX);

    NhaSX getById(Long id);
}
