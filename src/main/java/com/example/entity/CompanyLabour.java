package com.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company_labour")
public class CompanyLabour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "labour_id")
    private Labour labour;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "labour_salary", nullable = false)
    private Integer labourSalary;

}