package com.example.ClassRoomAPI.controllers;

import com.example.ClassRoomAPI.models.Course;
import com.example.ClassRoomAPI.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    // Guardar curso
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Course datosQueEnviaElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveCourse(datosQueEnviaElCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}


