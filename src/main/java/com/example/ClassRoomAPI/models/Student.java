package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer id;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Temporal(TemporalType.DATE)
    @Column(name = "born_date", nullable = false)
    private Date bornDate;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "student")
    @JsonManagedReference
    private Registration registration;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Attendance> attendances;

    // Getters, setters, constructor vacío y con parámetros
}
