package com.example.kiemtra.services;

import com.example.kiemtra.entity.NhanVien;
import com.example.kiemtra.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {

    @Autowired
    private INhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanViens(){
        return nhanVienRepository.findAll();
    }

    public NhanVien getNhanVienByMaNV(String maNV){
        return nhanVienRepository.findByMaNV(maNV);
    }

    public void addNhanVien(NhanVien book){
        nhanVienRepository.save(book);
    }

    public void deleteNhanVien(String maNV) {
        NhanVien nhanVien = nhanVienRepository.findByMaNV(maNV);
        if (nhanVien != null) {
            nhanVienRepository.delete(nhanVien);
        }
    }

    public void updateNhanVien(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

}
