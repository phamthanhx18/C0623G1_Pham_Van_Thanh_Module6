package com.example.beproject.service.impl;

import com.example.beproject.model.ClassRoom;
import com.example.beproject.repository.IClassRoomRepository;
import com.example.beproject.service.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    private IClassRoomRepository classRoomRepository;
    @Override
    public Boolean existsByNameClass(String className) {
        return classRoomRepository.existsByNameClass(className);
    }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom findById(Long id) {
        return classRoomRepository.findById(id).get();
    }
}
