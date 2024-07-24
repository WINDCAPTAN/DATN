package com.example.web_hshop.repository;

import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThuongHieuRepository extends JpaRepository<ThuongHieu,Long> {
    @Query(value = "select * from ThuongHieu where TrangThai = 1",nativeQuery = true)
    Page<ThuongHieu> fillAllDangHoatDong(Pageable pageable);

    @Query(value = "select * from ThuongHieu where TrangThai = 0",nativeQuery = true)
    Page<ThuongHieu> fillAllNgungHoatDong(Pageable pageable);

    Page<ThuongHieu> findByTenContaining(String keyword, Pageable pageable);
}
