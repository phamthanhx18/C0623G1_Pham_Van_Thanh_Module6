package com.example.beproject.service.impl;

import com.example.beproject.model.HinhThuc;
import com.example.beproject.model.Student;
import com.example.beproject.repository.IHinhThucRepository;
import com.example.beproject.repository.IStudentRepository;
import com.example.beproject.service.IHinhThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HinhThucService implements IHinhThucService {
    @Autowired
    private IHinhThucRepository hinhThucRepository;
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<Student> getTopPhat() {
        List<Long> listIdTopPhat = hinhThucRepository.getTopPhat();
        List<Student> studentList = new ArrayList<>();
        for (Long id:listIdTopPhat) {
            studentList.add(studentRepository.findById(id).get());
        }
        return studentList;
    }

    @Override
    public List<HinhThuc> getListThuongPhat(Long idStudent) {
        return hinhThucRepository.findAllByStudentIdStudent(idStudent);
    }

    @Override
    public List<Student> getListChuaDuocThuong() {
        List<Long> listIdTopPhat = hinhThucRepository.getTopChuaDuocThuong();
        List<Student> studentList = new ArrayList<>();
        for (Long id:listIdTopPhat) {
            studentList.add(studentRepository.findById(id).get());
        }
        return studentList;
    }

    @Override
    public void updateHinhThucByStudentId(Long studentId) {
        hinhThucRepository.updateHinhThucByStudentId(studentId);
    }
}
