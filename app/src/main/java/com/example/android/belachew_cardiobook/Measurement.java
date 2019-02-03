package com.example.android.belachew_cardiobook;

import java.util.UUID;

public class Measurement {
    private UUID ID; // to uniquely identify the measurements
    private String date;
    private String time;
    private String systolicPressure;
    private String diastolicPressure;
    private String heartRate;
    private String comment;

    public Measurement(String date, String time, String systolicPressure, String diastolicPressure, String heartRate, String comment) {
        this.date = date;
        this.time = time;
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.heartRate = heartRate;
        this.comment = comment;
        this.ID = UUID.randomUUID();
    }


    // Getters and Setters
    public UUID getID() {return ID;}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(String systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public String getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(String diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    // Returns the string version of the measurement, helpful for debugging.
    @Override
    public String toString() {
        return "ID: " + ID + ", DateMeasured: " + date +
                ", TimeMeasured: " + time + ", SystolicPressure: " + systolicPressure +
                ", DiastolicPressure: " + diastolicPressure + ", HeartRate: " + heartRate +
                ", Comment: " + comment;
    }



}
