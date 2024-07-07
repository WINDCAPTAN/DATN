package com.example.web_hshop.repository;

import com.example.web_hshop.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KichThuocRepository extends JpaRepository<KichCo,Long> {
}
