package com.example.healthmonitor.demo.controller;

import com.example.healthmonitor.entity.HeartRateRecord;
import com.example.healthmonitor.entity.Patient;
import com.example.healthmonitor.service.HeartRateService;
import com.example.healthmonitor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/heartrate")
public class HeartRateController {
    @Autowired
    private HeartRateService heartRateService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/record/{patientId}")
    public ResponseEntity<?> recordHeartRate(@PathVariable Long patientId, @RequestParam int heartRate) {
        Optional<Patient> patientOpt = patientService.getPatient(patientId);
        if (patientOpt.isPresent()) {
            HeartRateRecord record = heartRateService.recordHeartRate(patientOpt.get(), heartRate);
            return ResponseEntity.ok(record);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<HeartRateRecord>> getHeartRates(@PathVariable Long patientId) {
        List<HeartRateRecord> records = heartRateService.getHeartRates(patientId);
        return ResponseEntity.ok(records);
    }
}
