package com.example.ClassRoomAPI.services;

import com.example.ClassRoomAPI.helper.APIMessages;
import com.example.ClassRoomAPI.models.Attendance;
import com.example.ClassRoomAPI.models.Teacher;
import com.example.ClassRoomAPI.repository.IAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class AttendanceService {

    @Autowired
    IAttendanceRepository repository;

    //Method for save
    public Attendance saveAttendance(Attendance dataAttendance) throws Exception{
        try {
            return this.repository.save(dataAttendance);
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for searchAll
    public List<Attendance> attendanceList() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for SearchById
    public Attendance searchAttendanceById(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearched = this.repository.findById(id);
            if (attendanceSearched.isPresent()) {
                return attendanceSearched.get();
            } else {
                throw new Exception(APIMessages.ERROR_ATTENDANCE_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception();
        }
    }

    //Method for update
    public Attendance updateAttendance(Integer id, Attendance newAttendanceData) throws Exception {
        try {
            Optional<Attendance> attendanceSearchedForUpdating = this.repository.findById(id);
            if (attendanceSearchedForUpdating.isPresent()) {
                attendanceSearchedForUpdating.get().setDate(newAttendanceData.getDate());
                return this.repository.save(attendanceSearchedForUpdating.get());
            } else {
                throw new Exception(APIMessages.ERROR_ATTENDANCE_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Method for delete
    public Boolean deleteAttendance(Integer id) throws Exception{
        try {
            Optional<Attendance> attendanceSearched = this.repository.findById(id);
            if (attendanceSearched.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception(APIMessages.ERROR_ATTENDANCE_NOT_FOUND.getMessage());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
