package com.example.kiemtra.repository;

import com.example.kiemtra.entity.PhongBan;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PhongBan, Long> {
}
