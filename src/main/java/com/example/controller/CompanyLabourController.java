package com.example.controller;

import com.example.entity.Company;
import com.example.entity.CompanyLabour;
import com.example.entity.Labour;
import com.example.repository.CompanyLabourRepository;
import com.example.repository.CompanyRepository;

import com.example.repository.LabourRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vol1/cl")
public class CompanyLabourController {

    private CompanyRepository companyRepository;

    private LabourRepository labourRepository;

    private CompanyLabourRepository companyLabourRepository;


    public CompanyLabourController(
            CompanyRepository companyRepository, LabourRepository labourRepository,
            CompanyLabourRepository companyLabourRepository) {
        this.companyRepository = companyRepository;
        this.labourRepository = labourRepository;
        this.companyLabourRepository = companyLabourRepository;
    }
@PostMapping()
    public ResponseEntity<CompanyLabour> createCLPost(
            @RequestParam Long companyId,
            @RequestParam Long labourId,
            @RequestBody CompanyLabour companyLabour){

        Company company = companyRepository.findById(companyId).get();
        Labour labour = labourRepository.findById(labourId).get();
        companyLabour.setCompany(company);
        companyLabour.setLabour(labour);
        CompanyLabour save = companyLabourRepository.save(companyLabour);

        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
 }
