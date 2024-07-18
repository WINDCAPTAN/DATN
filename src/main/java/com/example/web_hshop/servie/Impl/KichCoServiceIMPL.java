package com.example.web_hshop.servie.Impl;

import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.repository.KichCoRepository;
import com.example.web_hshop.servie.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichCoServiceIMPL implements KichCoService {
    @Autowired
    private KichCoRepository kichCoRepository;

    @Override
    public List<KichCo> getAll(){
        return kichCoRepository.findAll();
    }
}
