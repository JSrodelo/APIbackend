package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Qualification;
import com.example.ClassRoomAPI.models.Registration;
import com.example.ClassRoomAPI.models.Subject;
import com.example.ClassRoomAPI.repository.IRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class RegistrationService {

    @Autowired
    IRegistrationRepository repository;

    //Method for save
    public Registration saveRegistration(Registration dataRegistration) throws Exception {
        try {
            return this.repository.save(dataRegistration);
        }catch (Exception error){
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<Registration> registrationList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public Registration searchRegistrationById(Integer id) throws Exception {
        try {
            Optional<Registration> registrationSearched = this.repository.findById(id);
            if (registrationSearched.isPresent()) {
                return registrationSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_REGISTRATION_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public Registration updateRegistration(Integer id, Registration newRegistrationData) throws Exception {
        try {
            Optional<Registration> registrationSearchedForUpdating = this.repository.findById(id);
            if (registrationSearchedForUpdating.isPresent()) {
                registrationSearchedForUpdating.get().setRegistrationDate(newRegistrationData.getRegistrationDate());
                return this.repository.save(registrationSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_REGISTRATION_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteRegistration(Integer id) throws Exception{
        try {
            Optional<Registration> registrationSearched = this.repository.findById(id);
            if (registrationSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_REGISTRATION_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
