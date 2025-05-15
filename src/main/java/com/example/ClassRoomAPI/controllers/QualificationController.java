package com.example.ClassRoomAPI.controllers;

import com.example.ClassRoomAPI.models.Qualification;
import com.example.ClassRoomAPI.services.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qualifications")
public class QualificationController {

    @Autowired
    QualificationService service;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Qualification datosQueEnviaElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.service.saveQualification(datosQueEnviaElCliente));
        } catch (Exception error) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
