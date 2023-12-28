package com.example.beproject.service;

import com.example.beproject.model.HinhThuc;
import com.example.beproject.model.Student;

import java.util.List;

public interface IHinhThucService  {
    List<Student> getTopPhat();
    List<HinhThuc> getListThuongPhat(Long idStudent);
    List<Student> getListChuaDuocThuong();
    void updateHinhThucByStudentId(Long studentId);
}
