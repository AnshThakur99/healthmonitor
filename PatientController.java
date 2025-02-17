package com.example.healthmonitor.demo.controller;

import com.example.healthmonitor.entity.Patient;
import com.example.healthmonitor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.addPatient(patient);
        return ResponseEntity.ok(savedPatient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {
        Optional<Patient> patientOpt = patientService.getPatient(id);
        if (patientOpt.isPresent()) {
            return ResponseEntity.ok(patientOpt.get());
        }
        return ResponseEntity.notFound().build();
    }
}
