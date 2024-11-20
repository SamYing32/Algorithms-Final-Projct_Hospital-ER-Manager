package com.algorithms.Hospital_Manager.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/next")
    public Patient getNextPatient() {
        return patientService.pollPatient();
    }

    @GetMapping("/peek")
    public Patient peekPatient() {
        return patientService.peekPatient();
    }

    @PostMapping("/add/param")
    public boolean addPatient(@RequestParam String name, @RequestParam LocalDate birthDate, @RequestParam String gender, @RequestParam int injurySeverity) {
        Patient p = new Patient(name, birthDate, gender, injurySeverity);
        return patientService.addPatient(p);
    }

    @PostMapping("/add")
    public boolean registerNewPatient(@RequestBody Patient patient) {
        patient.setCheckInTime(LocalTime.now());
        patient.setId();
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
    }

    @PutMapping("/update")
    public void updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
    }
}
