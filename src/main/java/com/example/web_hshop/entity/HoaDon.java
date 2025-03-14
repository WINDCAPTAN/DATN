package com.example.web_hshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HoaDon")
@Builder
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "MaHoaDon")
    private String maHoaDon;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "HH:mm dd-MM-yyyy")
    private Date ngaySua;

    @ManyToOne
    @JoinColumn(name = "IDTaiKhoan")
    private TaiKhoan taiKhoan;

}
