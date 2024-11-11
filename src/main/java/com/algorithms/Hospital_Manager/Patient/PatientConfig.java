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
            Patient sam = new Patient("Sam Ying", LocalDate.of(2000, 1, 5), "Male",  4);
            Patient mark = new Patient("Mark Su", LocalDate.of(2005, 4, 2), "Male", 7);
            patientService.addPatient(sam);
            patientService.addPatient(mark);
        };
    }
}
