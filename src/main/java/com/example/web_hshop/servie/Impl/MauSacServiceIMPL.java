package com.example.web_hshop.servie.Impl;

import com.example.web_hshop.entity.MauSac;
import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.MauSacRepository;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.servie.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceIMPL implements MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll(){
        return mauSacRepository.findAll();
    }
}
