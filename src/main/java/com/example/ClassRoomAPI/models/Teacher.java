package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Integer id;

    @Column(name = "specialty", nullable = false, length = 100)
    private String specialty;

    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Course> courses;

    // Getters, setters, constructor vacío y con parámetros
}
