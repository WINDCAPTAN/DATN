package com.example.web_hshop.service;

import com.example.web_hshop.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ThuongHieuService {



    Page<ThuongHieu> findAll(Pageable pageable);

    Page<ThuongHieu> getAllDangHoatDong(Pageable pageable);

    Page<ThuongHieu> getAllNgungHoatDong(Pageable pageable);

    void deleteById(Long id);

    ThuongHieu save(ThuongHieu thuongHieu);

    boolean checkTenTrung(String ten);

    boolean checkTenTrungSua(Long id, String ten);

    ThuongHieu update(ThuongHieu thuongHieu);

    ThuongHieu getById(Long id);


}
