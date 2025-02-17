package com.example.healthmonitor.demo.repository;

import com.example.healthmonitor.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
