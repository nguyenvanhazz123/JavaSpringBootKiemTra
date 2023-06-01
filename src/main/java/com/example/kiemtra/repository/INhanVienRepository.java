package com.example.kiemtra.repository;

import com.example.kiemtra.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NhanVien, Long> {
    NhanVien findByMaNV(String maNV);
}
