package com.algorithms.Hospital_Manager.Patient;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Table
public class Patient implements Comparable<Patient>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private String id;
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
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.injurySeverity = injurySeverity;
        this.checkInTime = LocalTime.now();
    }
    public Patient(String id, String name, LocalDate birthDate, String gender, int injurySeverity, LocalTime checkInTime) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.injurySeverity = injurySeverity;
        this.checkInTime = checkInTime;
    }

    public String getId() { return id; }

    public void setId() {
        this.id = UUID.randomUUID().toString();
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
        final int WAIT_TIME_THRESHOLD = 15 * 60;
        double thisWaitTime = ChronoUnit.SECONDS.between(this.getCheckInTime(), LocalTime.now()) + 0.1;
        double thatWaitTime = ChronoUnit.SECONDS.between(p.getCheckInTime(), LocalTime.now()) + 0.1;
        double thisPriorityScore = this.getInjurySeverity();
        double thatPriorityScore = p.getInjurySeverity();
        if (thisWaitTime > WAIT_TIME_THRESHOLD) {
            thisPriorityScore = (thisPriorityScore + 0.1) * thisWaitTime;
        }
        if (thatWaitTime > WAIT_TIME_THRESHOLD) {
            thatPriorityScore = (thatPriorityScore + 0.1) * thatWaitTime;
        }
        return Double.compare(thatPriorityScore, thisPriorityScore);
    }
}
