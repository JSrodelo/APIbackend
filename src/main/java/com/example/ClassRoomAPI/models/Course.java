package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_teacher", referencedColumnName = "id_teacher")
    @JsonBackReference
    private Teacher teacher;

    @OneToOne(mappedBy = "course")
    @JsonBackReference
    private Registration registration;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Subject> subjects;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendances;

    // Constructor vacío
    public Course() {}

    // Constructor con parámetros
    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    // Getters y Setters
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }
}
