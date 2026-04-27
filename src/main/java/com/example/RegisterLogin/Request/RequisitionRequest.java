package com.example.RegisterLogin.Request;

public class RequisitionRequest {
    private String driver;
    private String date;
    private String time;
    private String destination;
    private String purpose;

    public RequisitionRequest(String driver, String date, String time, String destination, String purpose) {

        this.driver = driver;
        this.date = date;
        this.time = time;
        this.destination = destination;
        this.purpose = purpose;
    }

    public RequisitionRequest() {
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "RequisitionRequest{" +
                "driver='" + driver + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", destination='" + destination + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
