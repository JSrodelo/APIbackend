package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Student;
import com.example.ClassRoomAPI.models.Subject;
import com.example.ClassRoomAPI.models.User;
import com.example.ClassRoomAPI.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class SubjectService {

    @Autowired
    ISubjectRepository repository;

    //Method for save
    public Subject saveSubject (Subject dataSubject) throws Exception {
        try {
            return this.repository.save(dataSubject);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<Subject> subjectList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public Subject searchSubjectById(Integer id) throws Exception {
        try {
            Optional<Subject> subjectSearched = this.repository.findById(id);
            if (subjectSearched.isPresent()) {
                return subjectSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public Subject updateSubject(Integer id, Subject newSubjectData) throws Exception {
        try {
            Optional<Subject> subjectSearchedForUpdating = this.repository.findById(id);
            if (subjectSearchedForUpdating.isPresent()) {
                subjectSearchedForUpdating.get().setName(newSubjectData.getClass());
                return this.repository.save(subjectSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteSubject(Integer id) throws Exception{
        try {
            Optional<Subject> subjectSearched = this.repository.findById(id);
            if (subjectSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_SUBJECT_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
