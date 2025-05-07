package com.example.ClassRoomAPI.models;

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
    @Column(name = "grade", unique = false, nullable = false)
    private Integer grade;
    @Temporal(TemporalType.DATE)
    @Column(name = "born_date", unique = false, nullable = false)
    private Date bornDate;
    @Column(name = "address", length = 255, unique = false, nullable = false)
    private String address;

    //Creating relationship with user (1 to 1)
    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id")
    @JsonManagedReference
    private User user;

    //Creating relationship with registration (1 to 1)
    @OneToOne(mappedBy = "student")
    @JsonManagedReference
    private Registration registration;

    //Creating relationship with qualification (one to many)
    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Qualification> qualifications;

    //Creating relationship with attendance (1 to many)
    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Attendance> attendances;

    public Student() {
    }

    public Student(Integer id, Integer grade, Date bornDate, String address) {
        this.id = id;
        this.grade = grade;
        this.bornDate = bornDate;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }
}
