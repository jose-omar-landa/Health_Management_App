package com.example.healthmanagerapp;

public class VitalsModal {


    private String date;
    private String bloodPressure;
    private String heartRate;
    private String otherSymptoms;
    private int id;

    public VitalsModal(String date, String bloodPressure, String heartRate, String otherSymptoms) {
        this.date = date;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.otherSymptoms = otherSymptoms;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getOtherSymptoms() {
        return otherSymptoms;
    }

    public void setOtherSymptoms(String otherSymptoms) {
        this.otherSymptoms = otherSymptoms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
