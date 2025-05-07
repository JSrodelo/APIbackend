package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Subject;
import com.example.ClassRoomAPI.models.Teacher;
import com.example.ClassRoomAPI.models.User;
import com.example.ClassRoomAPI.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    IUserRepository repository;

    //Method for save
    public User saveUser (User dataUser) throws Exception {
        try {
            return this.repository.save(dataUser);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<User> teacherList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public User searchUserById(Integer id) throws Exception {
        try {
            Optional<User> userSearched = this.repository.findById(id);
            if (userSearched.isPresent()) {
                return userSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_USER_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public User updateUser(Integer id, User newUserData) throws Exception {
        try {
            Optional<User> userSearchedForUpdating = this.repository.findById(id);
            if (userSearchedForUpdating.isPresent()) {
                userSearchedForUpdating.get().setName(newUserData.getName());
                return this.repository.save(userSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_USER_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteUser(Integer id) throws Exception{
        try {
            Optional<User> userSearched = this.repository.findById(id);
            if (userSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_USER_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
