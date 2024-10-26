package com.algorithms.Hospital_Manager.Patient;

public class Patient {
    private int position;
    private String name;
    private int injurySeverity;
    private Long waitingTime;

    public Patient() {
    }

    public Patient(int position, String name, int injurySeverity) {
        this.position = position;
        this.name = name;
        this.injurySeverity = injurySeverity;
        this.waitingTime = 0L;
    }

    public Patient(int position, String name, int injurySeverity, Long waitingTime) {
        this.position = position;
        this.name = name;
        this.waitingTime = waitingTime;
        this.injurySeverity = injurySeverity;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getInjurySeverity() {
        return injurySeverity;
    }

    public void setInjurySeverity(int injurySeverity) {
        this.injurySeverity = injurySeverity;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", waitingTime=" + waitingTime +
                ", injurySeverity=" + injurySeverity +
                '}';
    }
}
