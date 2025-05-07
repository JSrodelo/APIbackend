package com.example.ClassRoomAPI.repository;

import com.example.ClassRoomAPI.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepository extends JpaRepository<Attendance, Integer> {

}
