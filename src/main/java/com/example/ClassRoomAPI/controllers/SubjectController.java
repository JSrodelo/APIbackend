package com.example.ClassRoomAPI.controllers;

import com.example.ClassRoomAPI.models.Subject;
import com.example.ClassRoomAPI.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Subject datosQueEnviaElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveSubject(datosQueEnviaElCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
