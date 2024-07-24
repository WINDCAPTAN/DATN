package com.example.web_hshop.service.Impl;

import com.example.web_hshop.entity.NhaSX;
import com.example.web_hshop.entity.TayAo;
import com.example.web_hshop.repository.NhaSXRepository;
import com.example.web_hshop.service.NhaSXService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhaSXServiceIMPL implements NhaSXService {

    @Autowired
    private NhaSXRepository nhaSXRepo;


    @Override
    public Page<NhaSX> findAll(Pageable pageable) {

//        Sort sort = Sort.by(Sort.Direction.DESC, "ngaySua");
        return nhaSXRepo.findAll(pageable);

    }
    //    @Override
//    public Page<TayAo> getAllDangHoatDong(Pageable pageable) {
//        return tayAoRepstory.fillAllDangHoatDong(pageable);
//    }
//
//    @Override
//    public Page<ThuongHieu> getAllNgungHoatDong(Pageable pageable) {
//        return thuongHieuRepository.fillAllNgungHoatDong(pageable);
//    }
    @Override
    public void deleteById(Long id) {

    }

    @Override
    @Transactional
    public NhaSX save(NhaSX nhaSX) {

        return nhaSXRepo.save(nhaSX);

    }

    @Override
    public boolean checkTenTrung(String ten) {

        for (NhaSX nsx :  nhaSXRepo.findAll()) {
            if (nsx.getTen().equalsIgnoreCase(ten)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public boolean checkTenTrungSua(Long id, String ten) {

        for (NhaSX nsx : nhaSXRepo.findAll()) {
            if (nsx.getTen().equalsIgnoreCase(ten)) {
                if (!nsx.getId().equals(id)){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public NhaSX update(NhaSX nhaSX) {

        return nhaSXRepo.save(nhaSX);

    }

    @Override
    public NhaSX getById(Long id) {

        return nhaSXRepo.findById(id).get();

    }
}
