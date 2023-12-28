package com.example.beproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;
    private String nameStudent;
    private String birthday;
    private String email;
    private String phone;
    private String idCard;
    @ManyToOne(targetEntity = ClassRoom.class)
    @JsonManagedReference
    private ClassRoom classRoom;
}
