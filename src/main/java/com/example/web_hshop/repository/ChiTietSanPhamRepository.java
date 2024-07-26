package com.example.web_hshop.repository;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.entity.SanPhamChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChiTietSanPhamRepository extends JpaRepository<SanPhamChiTiet,Long> {
    @Transactional
    @Modifying
    @Query(value = " update ChiTietSanPham  set TrangThai = 1  where SoLuong =0", nativeQuery = true)
    void checkSoLuongBang0();

    @Query(value = "select * from ChiTietSanPham where TrangThai = 0 and SoLuong>0", nativeQuery = true)
    List<SanPhamChiTiet> fillAllDangHoatDongLonHon0();
}
