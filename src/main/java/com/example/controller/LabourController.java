package com.example.controller;

import com.example.entity.Labour;
import com.example.repository.LabourRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vol4/labour")
public class LabourController {

    private LabourRepository labourRepository;

    public LabourController(LabourRepository labourRepository) {
        this.labourRepository = labourRepository;
    }

    @PostMapping
    public ResponseEntity<Labour> createLabourPost(@RequestBody Labour labour){
        Labour save = labourRepository.save(labour);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
