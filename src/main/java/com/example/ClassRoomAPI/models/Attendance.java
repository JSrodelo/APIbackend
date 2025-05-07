package com.example.ClassRoomAPI.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.example.ClassRoomAPI.helper.State;
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

    //Creating relationship with student (many to one)
    @ManyToOne
    @JoinColumn(name = "fk_student", referencedColumnName = "id")
    @JsonManagedReference
    private Student student;

    //Creating relationship with course (many to one)
    @ManyToOne
    @JoinColumn(name = "fk_course", referencedColumnName = "id")
    @JsonManagedReference
    private Course course;

    public Attendance() {
    }

    public Attendance(Integer id, Date date, State state) {
        this.id = id;
        this.date = date;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
