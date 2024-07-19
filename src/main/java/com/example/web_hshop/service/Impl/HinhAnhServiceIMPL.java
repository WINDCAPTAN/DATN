package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.HinhAnh;
import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.repository.HinhAnhRepository;
import com.example.web_hshop.service.HinhAnhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class HinhAnhServiceIMPL implements HinhAnhService {

    @Autowired
    private HinhAnhRepository hinhAnhRepo;

    private Date currentDate = new Date();
    @Override
    public void saveImage(List<MultipartFile> files, SanPham sanPham) {
        for (MultipartFile multipartFile : files) {
            if (!multipartFile.isEmpty()) {
                try {
                    HinhAnh hinhAnh = new HinhAnh();
                    // Lưu tệp vào cơ sở dữ liệu
                    hinhAnh.setTen(multipartFile.getOriginalFilename());
                    hinhAnh.setNgayTao(currentDate);
                    hinhAnh.setNgaySua(currentDate);
                    hinhAnh.setTrangThai(false);
                    hinhAnh.setSanPham(sanPham);
                    // Thực hiện các tác vụ khác nếu cần thiết
                    hinhAnhRepo.save(hinhAnh);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Xử lý lỗi
                }
            }
        }
    }

    @Override
    public void saveWhenEditingImage(List<MultipartFile> files, Long id) {
        for (MultipartFile multipartFile : files) {
            if (!multipartFile.isEmpty()) {
                try {
                    HinhAnh hinhAnh = new HinhAnh();
                    // Lưu tệp vào cơ sở dữ liệu
                    hinhAnh.setTen(multipartFile.getOriginalFilename());
                    hinhAnh.setNgayTao(currentDate);
                    hinhAnh.setNgaySua(currentDate);
                    hinhAnh.setTrangThai(false);
                    hinhAnh.setSanPham(SanPham.builder().id(id).build());
                    // Thực hiện các tác vụ khác nếu cần thiết
                    hinhAnhRepo.save(hinhAnh);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Xử lý lỗi
                }
            }
        }
    }

    @Override
    public List<HinhAnh> listHinhAnh(Long id) {

        return hinhAnhRepo.fillAllByIdSp(id);

    }

    @Override
    public void deleteByID(Long id) {

    }
}
