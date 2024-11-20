package com.algorithms.Hospital_Manager.Patient;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class PatientService {

    private final Queue<Patient> patientQueue;

    public PatientService(PatientRepository patientRepository) {
        this.patientQueue = new PriorityQueue<>();
    }

    public List<Patient> getPatients() {
        return new ArrayList<>(patientQueue);
    }

    public boolean addPatient(Patient patient) {
        return patientQueue.add(patient);
    }

    public Patient pollPatient() {
        return patientQueue.poll();
    }

    public Patient peekPatient() {
        return patientQueue.peek();
    }

    public void deletePatient(String id) {
        patientQueue.removeIf(p -> p.getId().equals(id));
    }

    public void updatePatient(Patient patient) {
        for (Patient p : patientQueue) {
            if (p.getId().equals(patient.getId())) {
                Patient temp = new Patient(p.getId(), p.getName(), p.getBirthDate(), p.getGender(), patient.getInjurySeverity(), p.getCheckInTime());
                patientQueue.remove(p);
                patientQueue.add(temp);
                break;
            }
        }
    }
}
