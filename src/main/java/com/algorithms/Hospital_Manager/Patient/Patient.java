package com.algorithms.Hospital_Manager.Patient;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Patient implements Comparable<Patient>{
    @Id
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private int injurySeverity;
    private LocalTime checkInTime;
    @Transient
    private Integer age;

    public Patient() {
    }

    public Patient(String name, LocalDate birthDate, String gender, int injurySeverity) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.injurySeverity = injurySeverity;
        this.checkInTime = LocalTime.now();
    }

    public Long getId() { return id; }

    public void setId(Long position) {
        this.id = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getCheckInTime() { return checkInTime; }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public int getInjurySeverity() {
        return injurySeverity;
    }

    public void setInjurySeverity(int injurySeverity) {
        this.injurySeverity = injurySeverity;
    }

    public LocalDate getBirthDate() { return birthDate; }

    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) { this.age = age; }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", injurySeverity=" + injurySeverity +
                ", checkInTime=" + checkInTime +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Patient p) {
        long waitingTimeThis = ChronoUnit.SECONDS.between(this.getCheckInTime(), LocalTime.now());
        long waitingTimeThat = ChronoUnit.SECONDS.between(p.getCheckInTime(), LocalTime.now());

        if (waitingTimeThis > 900 || waitingTimeThat > 900) {
            if(waitingTimeThis > waitingTimeThat) {
                return 1;
            }
            return -1;
        }

        if (this.getInjurySeverity() > p.getInjurySeverity()) {
            return -1;
        }
        else if (p.getInjurySeverity() > this.getInjurySeverity()) {
            return 1;
        }

        if (waitingTimeThis > waitingTimeThat) {
            return -1;
        }
        else if (waitingTimeThis < waitingTimeThat) {
            return 1;
        }
        return 0;
    }
}
