package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_qualification")
    private Integer id;

    @Column(name = "score", nullable = false)
    private Float score;

    @Column(name = "test_date", nullable = false)
    private Date testDate;

    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fk_subject", referencedColumnName = "id_subject")
    @JsonBackReference
    private Subject subject;

    // Getters, setters, constructor vacío y con parámetros
}
