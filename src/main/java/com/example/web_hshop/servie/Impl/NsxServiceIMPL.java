package com.example.web_hshop.servie.Impl;

import com.example.web_hshop.entity.Nsx;
import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.NsxRepository;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.servie.NsxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NsxServiceIMPL implements NsxService {
    @Autowired
    private NsxRepository nsxRepository;

    @Override
    public List<Nsx> getAll(){
        return nsxRepository.findAll();
    }
}
