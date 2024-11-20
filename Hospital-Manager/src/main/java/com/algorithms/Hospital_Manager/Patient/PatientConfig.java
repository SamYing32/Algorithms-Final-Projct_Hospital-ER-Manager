package com.algorithms.Hospital_Manager.Patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PatientConfig {
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository repository, PatientService patientService) {
        return args -> {
            Patient[] patients = {
                    new Patient("Sam Ying", LocalDate.of(2000, 1, 5), "Male",  41),
                    new Patient("Mark Su", LocalDate.of(2005, 4, 2), "Male", 72),
                    new Patient("John Doe", LocalDate.of(1987, 2, 28), "Male", 66),
                    new Patient("Mary Jane", LocalDate.of(1967, 8, 20), "Female", 23),
                    new Patient("William", LocalDate.of(2018, 11, 18), "Male", 93),
                    new Patient("Mia", LocalDate.of(2009, 2, 11), "Female", 7),
            };
            for (Patient patient : patients) {
                patientService.addPatient(patient);
            }
        };
    }
}
