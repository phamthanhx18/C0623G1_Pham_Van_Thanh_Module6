package com.example.beproject.repository;

import com.example.beproject.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    Page<Student> getStudentsByClassRoomNameClass(Pageable pageable,String className);
    Student findByEmail(String email);
}
