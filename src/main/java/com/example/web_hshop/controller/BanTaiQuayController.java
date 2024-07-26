package com.example.web_hshop.controller;


import com.example.web_hshop.entity.HoaDon;
import com.example.web_hshop.entity.HoaDonChiTiet;
import com.example.web_hshop.entity.SanPhamChiTiet;
import com.example.web_hshop.entity.TaiKhoan;
import com.example.web_hshop.service.ChiTietSanPhamService;
import com.example.web_hshop.service.HoaDonChiTietService;
import com.example.web_hshop.service.HoaDonService;
import com.example.web_hshop.service.KhachHangService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/ban-hang-tai-quay")
public class BanTaiQuayController {
    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    ChiTietSanPhamService chiTietSanPhamSerivce;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/hoa-don")
    public String home() {
        request.setAttribute("lstHoaDon", hoaDonService.find5ByTrangThai(1));
        return "category/bantaiquay";
    }


    void addKhachLe() {
        if (khachHangService.findKhachLe() == null) {
            khachHangService.addKhachLe();
        }
    }


    @PostMapping("/hoa-don/add")
    public String taoHoaDon(RedirectAttributes redirectAttributes) {
        addKhachLe();
        if (hoaDonService.countHoaDonTreo() < 6) {
            HoaDon hd = new HoaDon();
            Date currentDate = new Date();
            hd.setTrangThai(1); // view 5 hoa don
            hd.setNgaySua(currentDate);
            hd.setNgayTao(currentDate);
            hd.setTaiKhoan(khachHangService.findKhachLe());
            hoaDonService.saveOrUpdate(hd);
            hd.setMaHoaDon("HD" + hd.getId());
            hoaDonService.saveOrUpdate(hd);
            return "redirect:/ban-hang-tai-quay/hoa-don/" + hd.getId();
        }
        return "redirect:/ban-hang-tai-quay/hoa-don";
    }
    @GetMapping("/hoa-don/{id}")
    public String hoaDon(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        chiTietSanPhamSerivce.checkSoLuongBang0();

        TaiKhoan tk = new TaiKhoan();
        model.addAttribute("khachHang", tk);
        model.addAttribute("lstHoaDon", hoaDonService.find5ByTrangThai(1));
        model.addAttribute("lstHdct", hoaDonChiTietService.findAll());
        model.addAttribute("lstCtsp", chiTietSanPhamSerivce.fillAllDangHoatDongLonHon0());
        model.addAttribute("lstTaiKhoan", khachHangService.getAll());

        HoaDon hd = hoaDonService.findById(id);
        model.addAttribute("hoaDon", hd);

        return "category/hoadonchitiet"; // Đảm bảo rằng đường dẫn này đúng với cấu trúc thư mục của bạn
    }

}
