package com.example.web_hshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SanPham")
@Entity
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "TrangThai")
    private boolean trangThai;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgaySua")
    private Date ngaySua;

    @ManyToOne
    @JoinColumn(name = "ID_ChatLieu")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "ID_ThuongHieu")
    private ThuongHieu thuongHieu;

    @OneToMany(mappedBy = "sanPham")
    private List<SanPhamChiTiet> chiTietSanPhams;

    public void updateSoLuong() {
        this.soLuong = chiTietSanPhams.stream().mapToInt(SanPhamChiTiet::getSoLuong).sum();
    }
}
