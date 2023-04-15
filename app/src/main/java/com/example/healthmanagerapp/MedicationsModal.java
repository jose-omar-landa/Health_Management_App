package com.example.healthmanagerapp;

public class MedicationsModal {

    private String name;
    private String dose;
    private String timeTaken;
    private String prescribedBy;
    private int id;

    public MedicationsModal(String name, String dose, String timeTaken, String prescribedBy) {
        this.name = name;
        this.dose = dose;
        this.timeTaken = timeTaken;
        this.prescribedBy = prescribedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
