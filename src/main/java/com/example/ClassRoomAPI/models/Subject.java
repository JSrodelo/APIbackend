package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subject")
    private Integer id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    //Creating relationship with course (many to 1)
    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "id")
    @JsonManagedReference
    private Course course;

    //Creating relationship with qualification (one to many)
    @OneToMany(mappedBy = "subject")
    @JsonManagedReference
    private List<Qualification> qualifications;

    public Subject() {
    }

    public Subject(Integer id, String name) {
        this.id = id;
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
