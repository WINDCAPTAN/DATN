package com.example.web_hshop.servie.Impl;

import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.entity.ThuongHieu;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.repository.ThuongHieuRepository;
import com.example.web_hshop.servie.TayAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TayAoServiceIMPL implements TayAoService {
    @Autowired
    private TayAoRepstory tayAoRepstory;

    @Override
    public List<TayAo> getAll(){
        return tayAoRepstory.findAll();
    }
}
