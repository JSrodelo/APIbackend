package com.example.ClassRoomAPI.models;

import com.example.ClassRoomAPI.helper.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attendance")
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "state", nullable = false)
    private State state;

    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;

    // Getters, setters, constructor vacío y con parámetros
}
