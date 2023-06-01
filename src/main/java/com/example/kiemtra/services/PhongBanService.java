package com.example.kiemtra.services;

import com.example.kiemtra.entity.PhongBan;
import com.example.kiemtra.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongBanRepository;
    public List<PhongBan> getAllPhongBans(){
        return phongBanRepository.findAll();
    }
    public PhongBan getPhongBanById(Long id){
        return phongBanRepository.findById(id).orElse(null);
    }
    public PhongBan savePhongBan(PhongBan phongBan){
        return phongBanRepository.save(phongBan);
    }
    public void deletePhongBan(Long id){
        phongBanRepository.deleteById(id);
    }
}
