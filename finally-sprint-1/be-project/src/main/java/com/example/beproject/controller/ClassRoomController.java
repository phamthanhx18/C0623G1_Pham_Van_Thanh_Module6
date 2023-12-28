package com.example.beproject.controller;

import com.example.beproject.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/classRoom")
@CrossOrigin("*")
@RestController
public class ClassRoomController {
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping
    public ResponseEntity<?> getAllClass() {
        return new ResponseEntity<>(classRoomService.getAllClassRoom(), HttpStatus.OK);
    }
}
