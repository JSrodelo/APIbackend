package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Attendance;
import com.example.ClassRoomAPI.models.Course;
import com.example.ClassRoomAPI.models.Qualification;
import com.example.ClassRoomAPI.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class CourseService {

    @Autowired
    ICourseRepository repository;

    //Method for save
    public Course saveCourse(Course dataCourse) throws Exception {
        try {
            return this.repository.save(dataCourse);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<Course> courseList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public Course searchCourseById(Integer id) throws Exception {
        try {
            Optional<Course> courseSearched = this.repository.findById(id);
            if (courseSearched.isPresent()) {
                return courseSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_COURSE_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public Course updateCourse(Integer id, Course newCourseData) throws Exception {
        try {
            Optional<Course> courseSearchedForUpdating = this.repository.findById(id);
            if (courseSearchedForUpdating.isPresent()) {
                courseSearchedForUpdating.get().setName(newCourseData.getName());
                return this.repository.save(courseSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_COURSE_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteCourse(Integer id) throws Exception{
        try {
            Optional<Course> courseSearched = this.repository.findById(id);
            if (courseSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_COURSE_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
