package com.algorithms.Hospital_Manager.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    void deletePatientById(Long id);
    boolean existsPatientById(Long id);
    Optional<Patient> findPatientById(Long id);
}
