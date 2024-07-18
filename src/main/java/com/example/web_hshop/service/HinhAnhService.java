package com.example.web_hshop.service;

import com.example.web_hshop.entity.HinhAnh;
import com.example.web_hshop.entity.SanPham;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface HinhAnhService {

    void saveImage(List<MultipartFile> files, SanPham sanPham);

    void saveWhenEditingImage(List<MultipartFile> files, Long id);

    List<HinhAnh> listHinhAnh(Long id);

    void deleteByID(Long id);

}
