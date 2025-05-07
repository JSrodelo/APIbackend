package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Course;
import com.example.ClassRoomAPI.models.Qualification;
import com.example.ClassRoomAPI.models.Teacher;
import com.example.ClassRoomAPI.repository.IQualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class QualificationService {

    @Autowired
    IQualificationRepository repository;

    //Method for save
    public Qualification saveQualification(Qualification dataQualification) throws Exception {
        try {
            return this.repository.save(dataQualification);
        } catch (Exception error){
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<Qualification> qualificationList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public Qualification searchQualificationById(Integer id) throws Exception {
        try {
            Optional<Qualification> qualificationSearched = this.repository.findById(id);
            if (qualificationSearched.isPresent()) {
                return qualificationSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_QUALIFICATION_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public Qualification updateQualification(Integer id, Qualification newQualificationData) throws Exception {
        try {
            Optional<Qualification> qualificationSearchedForUpdating = this.repository.findById(id);
            if (qualificationSearchedForUpdating.isPresent()) {
                qualificationSearchedForUpdating.get().setScore(newQualificationData.getScore());
                return this.repository.save(qualificationSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_QUALIFICATION_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteQualification(Integer id) throws Exception{
        try {
            Optional<Qualification> qualificationSearched = this.repository.findById(id);
            if (qualificationSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_QUALIFICATION_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
