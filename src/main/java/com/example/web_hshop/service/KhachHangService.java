package com.example.web_hshop.service;

import com.example.web_hshop.entity.TaiKhoan;
import com.example.web_hshop.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface KhachHangService {
    List<TaiKhoan> getAll();
    void addKhachLe();

    TaiKhoan findKhachLe();


}
