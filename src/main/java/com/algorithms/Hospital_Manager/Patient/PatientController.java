package com.algorithms.Hospital_Manager.Patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/find/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/add")
    public Patient registerNewPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
    }

    @PutMapping(path = "{patientId}")
    public void updatePatient(@PathVariable("patientId") Long id, @RequestParam(required = false) int injurySeverity) {
        patientService.updatePatient(id, injurySeverity);
    }
}
