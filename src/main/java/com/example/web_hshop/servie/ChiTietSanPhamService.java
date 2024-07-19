package com.example.web_hshop.servie;

import com.example.web_hshop.entity.SanPhamChiTiet;

import java.util.List;

public interface ChiTietSanPhamService {
    List<SanPhamChiTiet> getAll();

//    List<SanPhamChiTiet> getAllCtspOneSanPham();
List<SanPhamChiTiet> add(
        List<String> listSanPham, List<String> listKichCo,
        List<String> listMauSac, List<String> listTayAo,List<String> listChatLieu,
        List<String> listSoLuong, List<String> listDonGia );

    List<SanPhamChiTiet> updateAllCtsp(
            List<String> listIdChiTietSp, List<String> listSanPham,
            List<String> listKichCo, List<String> listMauSac,
            List<String> listTayAo, List<String> listTrangThai, List<String> listChatLieu,
            List<String> listSoLuong, List<String> listDonGia);

    SanPhamChiTiet update(SanPhamChiTiet chiTietSanPham);
    SanPhamChiTiet getById(Long id);
}
