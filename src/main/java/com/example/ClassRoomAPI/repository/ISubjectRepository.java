package com.example.ClassRoomAPI.repository;

import com.example.ClassRoomAPI.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
}
