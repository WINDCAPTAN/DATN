package com.example.web_hshop.repository;

import com.example.web_hshop.entity.TaiKhoan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<TaiKhoan, Long> {
    @Query(value = "SELECT * FROM NguoiDUNG WHERE IDVaiTro = 2 ORDER BY NgaySua DESC", nativeQuery = true)
    List<TaiKhoan> fillAllKhachHang();
    @Query(value = "select top(1) * from NguoiDung where HoTen =N'Khách lẻ'", nativeQuery = true)
    TaiKhoan findKhachLe();
    @Transactional
    @Modifying
    @Query(value = "INSERT into NguoiDung( HoTen, Email, TaiKhoan, MatKhau, SoDienThoai, NgaySinh, GioiTinh, TrangThai, NgayTao, NgaySua, IDVaiTro) \n" +
            "values \n" +
            "( N'Khách lẻ', NULL, NULL, NULL, NULL, NULL, NULL, NULL,-1, NULL,  NULL)", nativeQuery = true)
    void addKhachLe();
}
