package com.example.web_hshop.repository;

import com.example.web_hshop.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HinhAnhRepository extends JpaRepository<HinhAnh,Long> {
    @Query(value = "select * from Anh where IdSanPham = :id",nativeQuery = true)
    List<HinhAnh> fillAllByIdSp(@Param("id")Long id);
}
