package com.example.web_hshop.repository;

import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KichCoRepository extends JpaRepository<KichCo,Long> {
    @Query(value = "SELECT * FROM KichCo WHERE LOWER(Ten) = LOWER(:name)",nativeQuery = true)
    MauSac findMauSacByTen(@Param("name")String name);
    @Query(value = "SELECT MAX(CONVERT(varchar, SUBSTRING(Ma,3,10))) from KichCo",nativeQuery = true)
    Integer index();

    @Query(value = "SELECT * FROM KichCo ms WHERE (ms.Ten = ?1 OR ?1 IS NULL OR ?1 LIKE '')" +
            "AND (ms.TrangThai = ?2 OR ?2 IS NULL OR ?2 LIKE '')",nativeQuery = true)
    Page<KichCo> search(String ten, Boolean trangThai, Pageable pageable);
}
