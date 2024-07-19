package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.Nsx;
import com.example.web_hshop.repository.NsxRepository;
import com.example.web_hshop.service.NsxService;
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
