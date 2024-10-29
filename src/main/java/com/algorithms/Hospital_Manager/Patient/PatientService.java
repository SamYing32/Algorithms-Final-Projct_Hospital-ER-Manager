package com.algorithms.Hospital_Manager.Patient;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findPatientById(id).orElseThrow(() -> new IllegalStateException("Patient not found"));
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        boolean exists = patientRepository.existsPatientById(id);
        if (!exists) {
            throw new IllegalStateException("patient with id " + id + " does not exist");
        }
        patientRepository.deletePatientById(id);
    }

    @Transactional
    public void updatePatient(Long id, int injurySeverity) {
        Patient patient = patientRepository.findPatientById(id).orElseThrow(() -> new IllegalStateException("patient with id " + id + " does not exist"));
        if (injurySeverity >= 0) {
            patient.setInjurySeverity(injurySeverity);
        }
    }
}
