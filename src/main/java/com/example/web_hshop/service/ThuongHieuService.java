package com.example.web_hshop.service;

import com.example.web_hshop.entity.ThuongHieu;

import java.util.List;

public interface ThuongHieuService {


    List<ThuongHieu> getAll();

    ThuongHieu add(ThuongHieu thuongHieu);

    ThuongHieu update(ThuongHieu thuongHieu);

    void delete(Long id);

    ThuongHieu getById(Long id);


}
