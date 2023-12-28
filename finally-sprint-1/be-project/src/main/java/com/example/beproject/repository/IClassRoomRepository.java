package com.example.beproject.repository;

import com.example.beproject.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    Boolean existsByNameClass(String className);
}
