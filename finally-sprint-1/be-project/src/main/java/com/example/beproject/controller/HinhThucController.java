package com.example.beproject.controller;

import com.example.beproject.repository.IHinhThucRepository;
import com.example.beproject.service.IHinhThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HinhThucController {
    @Autowired
    private IHinhThucService hinhThucService;

    @GetMapping("/top/phat")
    public ResponseEntity<?> getTopPhat() {
        return new ResponseEntity<>(hinhThucService.getTopPhat(), HttpStatus.OK);
    }

    @GetMapping("/top/chua-thuong")
    public ResponseEntity<?> getListChuaThuong() {
        return new ResponseEntity<>(hinhThucService.getListChuaDuocThuong(), HttpStatus.OK);
    }

    @GetMapping("/hinh-thuc/{id}")
    public ResponseEntity<?> getListThuongPhat(@PathVariable Long id) {
        return new ResponseEntity<>(hinhThucService.getListThuongPhat(id), HttpStatus.OK);
    }

    @PatchMapping("/hinh-thuc/{id}")
    public ResponseEntity<?> hoanThanhThuongPhat(@PathVariable Long id) {
        try {
            hinhThucService.updateHinhThucByStudentId(id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
