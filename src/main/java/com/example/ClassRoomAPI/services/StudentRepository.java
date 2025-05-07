package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Course;
import com.example.ClassRoomAPI.models.Student;
import com.example.ClassRoomAPI.models.Subject;
import com.example.ClassRoomAPI.models.Teacher;
import com.example.ClassRoomAPI.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class StudentRepository {

    @Autowired
    IStudentRepository repository;

    //Method for save
    public Student saveStudent(Student dataStudent) throws Exception {
        try {
            return this.repository.save(dataStudent);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<Student> studentList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentSearched = this.repository.findById(id);
            if (studentSearched.isPresent()) {
                return studentSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_STUDENT_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public Student updateStudent(Integer id, Student newStudentData) throws Exception {
        try {
            Optional<Student> studentSearchedForUpdating = this.repository.findById(id);
            if (studentSearchedForUpdating.isPresent()) {
                studentSearchedForUpdating.get().setGrade(newStudentData.getGrade());
                return this.repository.save(studentSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_STUDENT_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteStudent(Integer id) throws Exception{
        try {
            Optional<Student> studentSearched = this.repository.findById(id);
            if (studentSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_STUDENT_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
