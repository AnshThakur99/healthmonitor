package com.example.healthmonitor.demo.service;

import com.example.healthmonitor.demo.entity.HeartRateRecord;
import com.example.healthmonitor.demo.entity.Patient;
import com.example.healthmonitor.demo.repository.HeartRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HeartRateService {
    @Autowired
    private HeartRateRepository heartRateRepository;

    public HeartRateRecord recordHeartRate(Patient patient, int heartRate) {
        HeartRateRecord record = new HeartRateRecord();
        record.setHeartRate(heartRate);
        record.setTimestamp(LocalDateTime.now());
        record.setPatient(patient);
        return heartRateRepository.save(record);
    }

    public List<HeartRateRecord> getHeartRates(Long patientId) {
        return heartRateRepository.findByPatientId(patientId);
    }
}
