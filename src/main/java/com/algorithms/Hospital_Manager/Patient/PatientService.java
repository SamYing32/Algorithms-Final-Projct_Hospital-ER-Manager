package com.algorithms.Hospital_Manager.Patient;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    public List<Patient> getPatients() {
        return List.of(
                new Patient(1, "Sam Ying", 4)
        );
    }
}
