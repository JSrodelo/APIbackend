package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer id;
    @Column(name = "name", length = 100, unique = false, nullable = false)
    private String name;

    //Creating relationship with teacher (many to 1)
    @ManyToOne
    @JoinColumn(name = "fk_teacher", referencedColumnName = "id")
    @JsonBackReference
    private Teacher teacher;

    //Creating relationship with registration (1 to 1)
    @OneToOne(mappedBy = "course")
    @JsonManagedReference
    private Registration registration;

    //Creating relationship with subject (1 to many)
    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Subject> subjects;

    //Creating relationship with attendance (1 to many)
    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendances;

    public Course() {
    }

    public Course(Integer idCourse, String name) {
        this.id = idCourse;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}