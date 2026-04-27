package com.example.RegisterLogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vehicleId;
    private String vehicleRegistrationNumber;
    private String make;
    private String type;
    private String driverId;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private String purpose;
    private int mileageOut;
    private int mileageIn;

    public Vehicle(Long id, Long vehicleId, String vehicleRegistrationNumber, String make, String type, String driverId, LocalTime timeIn, LocalTime timeOut, String purpose, int mileageOut, int mileageIn) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.make = make;
        this.type = type;
        this.driverId = driverId;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.purpose = purpose;
        this.mileageOut = mileageOut;
        this.mileageIn = mileageIn;
    }

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public double getMileageOut() {
        return mileageOut;
    }

    public void setMileageOut(int mileageOut) {
        this.mileageOut = mileageOut;
    }

    public int getMileageIn() {
        return mileageIn;
    }

    public void setMileageIn(int mileageIn) {
        this.mileageIn = mileageIn;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleId=" + vehicleId +
                ", vehicleRegistrationNumber='" + vehicleRegistrationNumber + '\'' +
                ", make='" + make + '\'' +
                ", type='" + type + '\'' +
                ", driverId='" + driverId + '\'' +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", purpose='" + purpose + '\'' +
                ", mileageOut=" + mileageOut +
                ", mileageIn=" + mileageIn +
                '}';
    }
}
