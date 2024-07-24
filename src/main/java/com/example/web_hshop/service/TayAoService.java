package com.example.web_hshop.service;

import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TayAoService {
    Page<TayAo> findAll(Pageable pageable);

//    Page<TayAo> getAllDangHoatDong(Pageable pageable);
//
//    Page<TayAo> getAllNgungHoatDong(Pageable pageable);

    void deleteById(Long id);

    TayAo save(TayAo tayAo);

    boolean checkTenTrung(String ten);

    boolean checkTenTrungSua(Long id, String ten);

    TayAo update(TayAo tayAo);

    TayAo getById(Long id);

}
