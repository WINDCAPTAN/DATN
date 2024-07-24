package com.example.web_hshop.repository;

import com.example.web_hshop.entity.NhaSX;
import com.example.web_hshop.entity.TayAo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhaSXRepository extends JpaRepository<NhaSX,Long> {
    Page<NhaSX> findByTenContaining(String keyword, Pageable pageable);
}
