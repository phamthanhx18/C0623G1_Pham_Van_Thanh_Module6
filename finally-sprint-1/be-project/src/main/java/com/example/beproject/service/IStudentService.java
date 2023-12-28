package com.example.beproject.service;

import com.example.beproject.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> getAllStudent(Pageable pageable);
    Page<Student> getAllStudentByClassName(Pageable pageable, String nameClass);
    void createStudent(Student student);
    Student findStudentByEmail(String email);
}
