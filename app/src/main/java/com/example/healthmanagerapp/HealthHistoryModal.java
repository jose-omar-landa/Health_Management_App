package com.example.healthmanagerapp;

public class HealthHistoryModal {

    private String healthProblem;
    private String diagnosedDate;
    private String diagnosedBy;
    private String otherInfo;
    private int id;

    public HealthHistoryModal(String healthProblem, String diagnosedDate, String diagnosedBy, String otherInfo) {
        this.healthProblem = healthProblem;
        this.diagnosedDate = diagnosedDate;
        this.diagnosedBy = diagnosedBy;
        this.otherInfo = otherInfo;
    }

    public String getHealthProblem() {
        return healthProblem;
    }

    public void setHealthProblem(String healthProblem) {
        this.healthProblem = healthProblem;
    }

    public String getDiagnosedDate() {
        return diagnosedDate;
    }

    public void setDiagnosedDate(String diagnosedDate) {
        this.diagnosedDate = diagnosedDate;
    }

    public String getDiagnosedBy() {
        return diagnosedBy;
    }

    public void setDiagnosedBy(String diagnosedBy) {
        this.diagnosedBy = diagnosedBy;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
