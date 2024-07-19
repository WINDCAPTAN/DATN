package com.example.web_hshop.controller;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.entity.SanPhamChiTiet;
import com.example.web_hshop.repository.ChatLieuRepository;
import com.example.web_hshop.repository.ChiTietSanPhamRepository;
import com.example.web_hshop.repository.KichCoRepository;
import com.example.web_hshop.repository.MauSacRepository;
import com.example.web_hshop.repository.SanPhamRepository;
import com.example.web_hshop.repository.TayAoRepstory;
import com.example.web_hshop.service.ChatLieuService;
import com.example.web_hshop.service.ChiTietSanPhamService;
import com.example.web_hshop.service.KichCoService;
import com.example.web_hshop.service.MauSacService;
import com.example.web_hshop.service.SanPhamService;
import com.example.web_hshop.service.TayAoService;
import com.example.web_hshop.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/san-pham-chi-tiet")
public class ChiTietSanPhamController {

    @Autowired
    private ThuongHieuService thuongHieuService;
    @Autowired
    private KichCoService kichCoService;

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private TayAoService tayAoService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private ChatLieuService chatLieuService;
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private KichCoRepository kichCoRepository;

    @Autowired
    private TayAoRepstory tayAoRepstory;

    @Autowired
    private ChatLieuRepository chatLieuRepository;



//    private Model getString(Model model) {
//        model.addAttribute("listSanPham", sanPhamSerivce.getAllDangHoatDong());
//        model.addAttribute("listThuongHieu", thuongHieuService.getAllDangHoatDong());
//        model.addAttribute("listKichCo", kichCoService.getAllDangHoatDong());
//        model.addAttribute("listMauSac", mauSacService.getAllDangHoatDong());
//        model.addAttribute("listLoaiDe", loaiDeService.getAllDangHoatDong());
//        return model;
//    }

    @GetMapping()
    public String hienThi(Model model) {
        model.addAttribute("listChiTietSP", chiTietSanPhamService.getAll());
        model.addAttribute("sanPham", new SanPham());
        model.addAttribute("listSanPham", sanPhamService.getAll());
        model.addAttribute("listChatLieu", chatLieuService.getAll());
        model.addAttribute("listKichCo", kichCoService.getAll());
        model.addAttribute("listMauSac", mauSacService.getAll());
        model.addAttribute("listTayAo", tayAoService.getAll());
//        model.addAttribute("thuongHieu", new ThuongHieu());
//        model.addAttribute("kichCo", new KichCo());
//        model.addAttribute("mauSac", new MauSac());
        return "/category/sanphamct/sanphamchitiet";
    }
    @PostMapping("/add")
    public String add(
            @RequestParam("listSanPham") List<String> listSanPham,
            @RequestParam("listKichCo") List<String> listKichCo,
            @RequestParam("listMauSac") List<String> listMauSac,
            @RequestParam("listTayAo") List<String> listTayAo,
            @RequestParam("listChatLieu") List<String> listChatLieu,
            @RequestParam("listSoLuong") List<String> listSoLuong,
            @RequestParam("listDonGia") List<String> listDonGia,
            RedirectAttributes attributes
    ) {
        attributes.addFlashAttribute("checkThongBao", "thanhCong");
        chiTietSanPhamService.add(listSanPham, listKichCo, listMauSac, listTayAo, listChatLieu, listSoLuong, listDonGia);
        return "redirect:/san-pham-chi-tiet";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdate(
            @PathVariable("id") Long id,
            Model model
    ) {

        SanPham sanPham = sanPhamService.getById(id);
        List<SanPhamChiTiet> listChiTietSP = chiTietSanPhamService.getAll();
        model.addAttribute("sanPhamDetail", sanPham);
        model.addAttribute("listChiTietSP", listChiTietSP);
        model.addAttribute("listTA", tayAoService.getAll());
        model.addAttribute("listCL", chatLieuService.getAll());
        return "/category/sanphamct/suasanphamchitiet";
    }
}
