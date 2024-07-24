package com.example.web_hshop.service;

import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KichCoService {
    List<KichCo> getAll();
    KichCo add(KichCo kichCo);
    KichCo update(KichCo kichCo);
    KichCo getById(Long id);
    Integer genMaTuDong();
    Page<KichCo> search(String ten, Boolean trangThai, Pageable pageable);
}
