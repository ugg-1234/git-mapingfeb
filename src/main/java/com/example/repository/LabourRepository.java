package com.example.repository;

import com.example.entity.Labour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabourRepository extends JpaRepository<Labour, Long> {
}