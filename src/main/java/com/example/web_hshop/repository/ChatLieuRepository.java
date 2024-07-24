package com.example.web_hshop.repository;

import com.example.web_hshop.entity.ChatLieu;

import com.example.web_hshop.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatLieuRepository extends JpaRepository<ChatLieu, Long> {
    //    List<ChatLieu> findAllByOrderByNgayTaoDesc();
    @Query(value = "SELECT * FROM ChatLieu WHERE LOWER(Ten) = LOWER(:name)", nativeQuery = true)
    ChatLieu findChatLieuByTen(@Param("name") String name);
    @Query(value = "SELECT MAX(CONVERT(varchar, SUBSTRING(Ma,3,10))) from ChatLieu", nativeQuery = true)
    Integer index();
    @Query(value = "SELECT * FROM ChatLieu ms WHERE (ms.Ten = ?1 OR ?1 IS NULL OR ?1 LIKE '')" +
            "AND (ms.TrangThai = ?2 OR ?2 IS NULL OR ?2 LIKE '')",nativeQuery = true)
    Page<ChatLieu> search(String ten, Boolean trangThai, Pageable pageable);
}
