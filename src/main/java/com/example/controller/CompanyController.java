package com.example.controller;

import com.example.entity.Company;
import com.example.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vol3/company")
public class CompanyController {

    private CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @PostMapping
    public ResponseEntity<Company> createCompanyPost(@RequestBody Company company){
        Company save = companyRepository.save(company);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
