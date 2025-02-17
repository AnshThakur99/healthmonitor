package com.example.healthmonitor.demo.service;

import com.example.healthmonitor.demo.entity.Patient;
import com.example.healthmonitor.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatient(Long id) {
        return patientRepository.findById(id);
    }
}
