package com.algorithms.Hospital_Manager.Patient;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {

    private final Queue<Patient> patientQueue;

    public PatientService() {
        this.patientQueue = new PriorityQueue<>();
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patientQueue);
    }

//    public Patient getPatientById(Long id) {
//        return patientRepository.findPatientById(id).orElseThrow(() -> new IllegalStateException("Patient not found"));
//    }

    public boolean addPatient(Patient patient) {
        return patientQueue.add(patient);
    }

    public Patient pollPatient() {
        return patientQueue.poll();
    }

    public Patient peekPatient() {
        return patientQueue.peek();
    }

//    public void deletePatient(Long id) {
//        boolean exists = patientRepository.existsPatientById(id);
//        if (!exists) {
//            throw new IllegalStateException("patient with id " + id + " does not exist");
//        }
//        patientRepository.deletePatientById(id);
//    }

    public void updatePatient(Patient patient) {
        patientQueue.removeIf(value -> value.equals(patient));
        patientQueue.add(patient);
    }
}
