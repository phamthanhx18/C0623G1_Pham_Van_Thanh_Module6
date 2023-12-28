package com.example.beproject.controller;

import com.example.beproject.dto.StudentDTO;
import com.example.beproject.model.ClassRoom;
import com.example.beproject.model.Student;
import com.example.beproject.service.IClassRoomService;
import com.example.beproject.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/students")
@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping
    public ResponseEntity<?> getAllStudents(@PageableDefault(size = 5) Pageable pageable) {
        Page<Student> studentPage = studentService.getAllStudent(pageable);
        if (studentPage.getContent().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentPage, HttpStatus.OK);
    }

    @GetMapping("/getByClass")
    public ResponseEntity<?> getAllStudentsByClassName(@PageableDefault(size = 5) Pageable pageable, @RequestParam String className) {
        if (!classRoomService.existsByNameClass(className)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Page<Student> studentPage = studentService.getAllStudentByClassName(pageable, className);
        if (studentPage.getContent().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentPage, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        if (studentService.findStudentByEmail(studentDTO.getEmail()) != null) {
            return new ResponseEntity<>("Email đã tồn tại trong hệ thống !", HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        ClassRoom classRoom = classRoomService.findById(studentDTO.getClassId());
        student.setClassRoom(classRoom);
        try {
            studentService.createStudent(student);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
