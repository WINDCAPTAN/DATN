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

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChiTietSanPham")
@Entity
@Builder
public class SanPhamChiTiet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "GiaBan")
    private Long giaBan;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "MaVach")
    private String maVach;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "NgayTao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTao;

    @Column(name = "NgaySua")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaySua;

    @ManyToOne
    @JoinColumn(name = "IDKichCo")
    private KichCo kichCo;

    @ManyToOne
    @JoinColumn(name = "IDMauSac")
    private MauSac mauSac;

//    @ManyToOne
//    @JoinColumn(name = "IDThuongHieu")
//    private ThuongHieu thuongHieu;

//    @ManyToOne()
//    @JoinColumn(name = "IDTayAo")
//    private

    @ManyToOne
    @JoinColumn(name = "IDSanPham")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IDTayAo")
    private TayAo tayAo;
    @ManyToOne
    @JoinColumn(name = "IDChatLieu")
    private ChatLieu chatLieu;
}
