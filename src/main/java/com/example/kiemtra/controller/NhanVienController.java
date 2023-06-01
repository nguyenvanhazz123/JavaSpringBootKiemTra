package com.example.kiemtra.controller;


import com.example.kiemtra.entity.NhanVien;
import com.example.kiemtra.services.NhanVienService;
import com.example.kiemtra.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/nhanViens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanViens(Model model){
        List<NhanVien> nhanViens = nhanVienService.getAllNhanViens();
        model.addAttribute("nhanViens", nhanViens);
        return "nhanVien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanVien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien, BindingResult result, Model model){
        // check lỗi
        if(result.hasErrors()){
            model.addAttribute("phongBans",phongBanService.getAllPhongBans());
            return "nhanVien/add";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanViens";
    }

    @GetMapping("/delete/{maNV}")
    public String deleteNhanVien(@PathVariable("maNV") String maNV, Model model){
        NhanVien nhanVien = nhanVienService.getNhanVienByMaNV(maNV);
        nhanVienService.deleteNhanVien(maNV);
        return "redirect:/nhanViens";
    }

    @GetMapping("/edit/{maNV}")
    public String edit(@PathVariable("maNV") String maNV, Model model){
        model.addAttribute("nhanVien",  nhanVienService.getNhanVienByMaNV(maNV));
        model.addAttribute("phongBans", phongBanService.getAllPhongBans());
        return "nhanVien/edit";

    }
    @PostMapping("/edit")
    public String edit(@Valid NhanVien editNhanVien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("nhanVien", editNhanVien);
            model.addAttribute("phongBans",phongBanService.getAllPhongBans());
            return "nhanVien/edit";
        }
        nhanVienService.updateNhanVien(editNhanVien);
        return "redirect:/nhanViens";
    }
}
