package com.example.kiemtra.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;

@Data
@Entity
@Table(name="NhanVien")
public class NhanVien {


    @Column(name="maNV")
    @Id
    private String maNV;

    @Column(name="tenNV")
    private String tenNV;

    @Column(name="gioiTinh")
    private String gioiTinh;

    @Column(name="noiSinh")
    private String noiSinh;

    @Column(name = "luong")
    private Double luong;

    @ManyToOne
    @JoinColumn(name ="maPhongBan", referencedColumnName = "maPhong")
    private PhongBan phongBan;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
