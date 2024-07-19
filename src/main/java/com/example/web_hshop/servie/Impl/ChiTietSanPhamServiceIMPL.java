package com.example.web_hshop.servie.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.example.web_hshop.entity.ChatLieu;
import com.example.web_hshop.entity.KichCo;
import com.example.web_hshop.entity.MauSac;
import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.entity.SanPhamChiTiet;
import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.ChiTietSanPhamRepository;
import com.example.web_hshop.servie.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
//import java.sql.Date; // Import java.sql.Date
import java.util.List;
@Service
public class ChiTietSanPhamServiceIMPL implements ChiTietSanPhamService {

    private static final Logger logger = LoggerFactory.getLogger(ChiTietSanPhamServiceIMPL.class);

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<SanPhamChiTiet> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public List<SanPhamChiTiet> add(
            List<String> listSanPham, List<String> listKichCo,
            List<String> listMauSac, List<String> listTayAo,List<String> listChatLieu,
            List<String> listSoLuong, List<String> listDonGia ) {

        List<SanPhamChiTiet> chiTietSanPhamList = new ArrayList<>();
        List<SanPhamChiTiet> listCtspCheck = chiTietSanPhamRepository.findAll();

        for (int i = 0; i < listSanPham.size(); i++) {
            SanPhamChiTiet chiTietSanPham = new SanPhamChiTiet();
            boolean isUpdated = false;

            logger.info("Processing: SanPhamID: {}, KichCoID: {}, MauSacID: {}, TayAoID: {}, ChatLieuID: {}",
                    listSanPham.get(i), listKichCo.get(i), listMauSac.get(i), listTayAo.get(i), listChatLieu.get(i));

            for (SanPhamChiTiet listCheck : listCtspCheck) {
                if (listCheck.getSanPham().getId().equals(Long.valueOf(listSanPham.get(i))) &&
                        listCheck.getKichCo().getId().equals(Long.valueOf(listKichCo.get(i))) &&
                        listCheck.getMauSac().getId().equals(Long.valueOf(listMauSac.get(i))) &&
                        listCheck.getTayAo().getId().equals(Long.valueOf(listTayAo.get(i))) &&
                        listCheck.getChatLieu().getId().equals(Long.valueOf(listChatLieu.get(i)))
                ) {
                    int soLuongMoi = Integer.parseInt(listSoLuong.get(i));
                    listCheck.setSoLuong(listCheck.getSoLuong() + soLuongMoi);
                    listCheck.setGiaBan(Long.valueOf(listDonGia.get(i)));
                    listCheck.setTrangThai(0);

                    // Correct conversion from java.util.Date to java.sql.Date
                    listCheck.setNgaySua(new java.sql.Date(new Date().getTime()));

                    SanPhamChiTiet updatedChiTietSanPham = chiTietSanPhamRepository.save(listCheck);
                    chiTietSanPhamList.add(updatedChiTietSanPham);

                    isUpdated = true;
                    break;
                }
            }
            if (!isUpdated) {
                chiTietSanPham.setSanPham(SanPham.builder().id(Long.valueOf(listSanPham.get(i))).build());
                chiTietSanPham.setKichCo(KichCo.builder().id(Long.valueOf(listKichCo.get(i))).build());
                chiTietSanPham.setMauSac(MauSac.builder().id(Long.valueOf(listMauSac.get(i))).build());
                chiTietSanPham.setTayAo(TayAo.builder().id(Long.valueOf(listTayAo.get(i))).build());
                chiTietSanPham.setChatLieu(ChatLieu.builder().id(Long.valueOf(listChatLieu.get(i))).build());
                chiTietSanPham.setSoLuong(Integer.parseInt(listSoLuong.get(i)));
                chiTietSanPham.setGiaBan(Long.valueOf(listDonGia.get(i)));
                chiTietSanPham.setTrangThai(0);

                // Correct conversion from java.util.Date to java.sql.Date
                java.sql.Date currentDate = new java.sql.Date(new Date().getTime());
                chiTietSanPham.setNgayTao(currentDate);
                chiTietSanPham.setNgaySua(currentDate);

                if (chiTietSanPham.getSoLuong() > 0) {
                    SanPhamChiTiet savedChiTietSanPham = chiTietSanPhamRepository.save(chiTietSanPham);
                    chiTietSanPhamList.add(savedChiTietSanPham);
                }
            }
        }
        return chiTietSanPhamList;
    }

    @Override
    public List<SanPhamChiTiet> updateAllCtsp(
            List<String> listIdChiTietSp, List<String> listSanPham,
            List<String> listKichCo, List<String> listMauSac,
            List<String> listTayAo, List<String> listTrangThai,
            List<String> listChatLieu, List<String> listSoLuong, List<String> listDonGia) {
        SanPhamChiTiet chiTietSanPhamNew = this.getById(Long.valueOf(listIdChiTietSp.get(0)));
        List<SanPhamChiTiet> chiTietSanPhamList = new ArrayList<>();
        for (int i = 0; i < listSanPham.size(); i++) {
            SanPhamChiTiet chiTietSanPham = new SanPhamChiTiet();
            chiTietSanPham.setId(Long.valueOf(listIdChiTietSp.get(i)));
            chiTietSanPham.setSanPham(SanPham.builder().id(Long.valueOf(listSanPham.get(i))).build());
            chiTietSanPham.setKichCo(KichCo.builder().id(Long.valueOf(listKichCo.get(i))).build());
            chiTietSanPham.setMauSac(MauSac.builder().id(Long.valueOf(listMauSac.get(i))).build());
            chiTietSanPham.setTayAo(TayAo.builder().id(Long.valueOf(listTayAo.get(i))).build());
            chiTietSanPham.setChatLieu(ChatLieu.builder().id(Long.valueOf(listChatLieu.get(i))).build());
            chiTietSanPham.setTrangThai(Integer.parseInt(listTrangThai.get(i)));
            chiTietSanPham.setSoLuong(Integer.parseInt(listSoLuong.get(i)));
            chiTietSanPham.setNgayTao(chiTietSanPhamNew.getNgayTao());
            chiTietSanPham.setNgaySua(chiTietSanPhamNew.getNgaySua());
            SanPhamChiTiet savedChiTietSanPham = chiTietSanPhamRepository.save(chiTietSanPham);
            chiTietSanPhamList.add(savedChiTietSanPham);
        }
        return chiTietSanPhamList;
    }

    @Override
    public SanPhamChiTiet update(SanPhamChiTiet sanPham) {
        return chiTietSanPhamRepository.save(sanPham);
    }

    @Override
    public SanPhamChiTiet getById(Long id) {
        return chiTietSanPhamRepository.findById(id).get();
    }
}
