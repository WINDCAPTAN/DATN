package com.example.web_hshop.repository;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanPhamChiTietRepository extends JpaRepository<SanPhamChiTiet,Long> {
    List<SanPhamChiTiet> findBySanPham(SanPham sanPham);
}
