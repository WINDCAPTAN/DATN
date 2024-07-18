package com.example.web_hshop.servie.Impl;

import com.example.web_hshop.entity.ThuongHieu;
import com.example.web_hshop.repository.ThuongHieuRepository;
import com.example.web_hshop.servie.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThuongHieuIMPL implements ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieurepo;

    @Override
    public List<ThuongHieu> getAll(){
        return thuongHieurepo.findAll();
    }


}
