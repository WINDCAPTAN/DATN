package com.example.web_hshop.repository;

import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TayAoRepstory extends JpaRepository<TayAo, Long> {
    Page<TayAo> findByTenContaining(String keyword, Pageable pageable);
}
