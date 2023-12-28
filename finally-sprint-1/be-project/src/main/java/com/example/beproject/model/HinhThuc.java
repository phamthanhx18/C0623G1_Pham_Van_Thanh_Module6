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
@Table
public class HinhThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Student.class)
    private Student student;
    @ManyToOne(targetEntity = TypeBonus.class)
    private TypeBonus typeBonus;
    private String note;
    private String dateCreate;
    @JsonManagedReference
    @ManyToOne(targetEntity = Status.class)
    private Status status;
}
