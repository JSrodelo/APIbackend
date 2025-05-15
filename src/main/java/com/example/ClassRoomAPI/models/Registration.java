package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration")
    private Integer id;

    @Column(name = "registration_date")
    private Timestamp registrationDate;

    @OneToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @OneToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "id_course")
    @JsonManagedReference
    private Course course;

    // Getters, setters, constructor vacío y con parámetros
}
