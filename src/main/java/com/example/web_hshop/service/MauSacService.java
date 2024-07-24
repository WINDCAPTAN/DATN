package com.example.web_hshop.service;

import com.example.web_hshop.controller.MauSacController;
import com.example.web_hshop.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MauSacService {
    List<MauSac> getAll();
    MauSac add(MauSac mauSac);
    MauSac update(MauSac mauSac);
    MauSac getById(Long id);
    boolean checkTenTrung(String ten);

    Integer genMaTuDong();
    Optional<MauSac> findByTen(String ten);
    Page<MauSac> search(String ten, Boolean trangThai, Pageable pageable);
}

