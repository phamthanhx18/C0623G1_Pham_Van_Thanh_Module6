package com.example.project.controller;

import com.example.project.payload.request.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/test")
    public ResponseEntity<LoginRequest> test(@RequestBody LoginRequest loginRequest) {
        System.out.println(loginRequest);
        return new ResponseEntity<>(loginRequest, HttpStatus.OK);
    }
}
