package com.example.beproject.service.impl;

import com.example.beproject.model.Student;
import com.example.beproject.repository.IStudentRepository;
import com.example.beproject.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> getAllStudentByClassName(Pageable pageable, String nameClass) {
        return studentRepository.getStudentsByClassRoomNameClass(pageable,nameClass);
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}
