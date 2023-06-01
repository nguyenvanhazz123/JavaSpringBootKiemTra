package com.example.kiemtra.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="PhongBan")
public class PhongBan {

    @Id
    @Column(name = "maPhong")
    private String maPhong;

    @Column(name="tenPB")
    private String tenPB;

    @OneToMany(mappedBy= "phongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}
