package com.example.web_hshop.service;

import com.example.web_hshop.entity.NhaSX;

import java.util.List;

public interface NhaSXService {
    List<NhaSX> getAll();

    NhaSX add(NhaSX nhaSX);

    NhaSX update(NhaSX nhaSX);

    void delete(Long id);

    NhaSX getById(Long id);
}
