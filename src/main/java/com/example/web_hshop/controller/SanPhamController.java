package com.example.web_hshop.controller;

import com.example.web_hshop.entity.SanPham;
import com.example.web_hshop.repository.NhaSXRepository;
import com.example.web_hshop.repository.SanPhamRepository;
import com.example.web_hshop.repository.ThuongHieuRepository;
import com.example.web_hshop.service.HinhAnhService;
import com.example.web_hshop.service.NhaSXService;
import com.example.web_hshop.service.SanPhamService;
import com.example.web_hshop.service.ThuongHieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {

    @Autowired
    private HinhAnhService hinhAnhService;

    @Autowired
    private SanPhamService sanPhamService;

    @Autowired
    private ThuongHieuService thuongHieuService;

    @Autowired
    private NhaSXService nhaSXService;

    @GetMapping
    public String hienThi(Model model){
        model.addAttribute("listNSX",nhaSXService.findAll(Pageable.unpaged()));
        model.addAttribute("listTH",thuongHieuService.findAll(Pageable.unpaged()));
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("sanPham", new SanPham() );
        return "category/sanpham/sanpham";
    }

    @PostMapping("/add")
    public String addSP(@ModelAttribute("sanPham")SanPham sanPham,
                        @RequestParam("files")List<MultipartFile> files){
        sanPham.setNgayTao(new Date());
        sanPham.setNgaySua(new Date());
        sanPham.setSoLuong(0);
        sanPham.setTrangThai(true);
        sanPhamService.add(sanPham);
        hinhAnhService.saveImage(files,sanPham);
        return "redirect:/san-pham ";
    }

    @GetMapping("/view-update/{id}")
    public String viewUD(@PathVariable("id")Long id,
                         Model model){
        SanPham sanPham = sanPhamService.getById(id);
        model.addAttribute("listTH",thuongHieuService.findAll(Pageable.unpaged()));
        model.addAttribute("listNSX",nhaSXService.findAll(Pageable.unpaged()));
        model.addAttribute("listUD",sanPham);
        return "category/sanpham/sanpham-update";
    }

    @PostMapping("/update")
    public String updateSP(@ModelAttribute("sanPham")SanPham sanPham,
                           @RequestParam("files")List<MultipartFile> files){
        SanPham sp = sanPhamService.getById(sanPham.getId());
        sanPham.setNgayTao(sp.getNgayTao());
        sanPham.setNgaySua(new Date());
        for (MultipartFile file : files) {
            if (file != null && !file.isEmpty()) {
                hinhAnhService.deleteByID(sanPham.getId());
            }
        }
        hinhAnhService.saveWhenEditingImage(files, sanPham.getId());
        sanPhamService.update(sanPham);
        return "redirect:/san-pham ";
    }

}
