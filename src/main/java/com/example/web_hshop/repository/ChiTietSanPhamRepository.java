package com.example.web_hshop.repository;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.entity.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChiTietSanPhamRepository extends JpaRepository<SanPhamChiTiet,Long> {

}
