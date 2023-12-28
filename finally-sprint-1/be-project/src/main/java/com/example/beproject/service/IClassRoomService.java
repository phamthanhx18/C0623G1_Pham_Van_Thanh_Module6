package com.example.beproject.service;

import com.example.beproject.model.ClassRoom;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IClassRoomService {
    Boolean existsByNameClass(String className);
    List<ClassRoom> getAllClassRoom();
    ClassRoom findById(Long id);
}
