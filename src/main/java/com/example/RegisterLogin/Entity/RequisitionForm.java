package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class RequisitionForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requisitionFormId;
    private String destination;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private LocalDate dateIn;
    private LocalDate dateOut;
    private double fuelIn;
    private double fuelOut;
    private int mileageOut;
    private int mileageIn;
    private String purpose;
    private String vehicleRegistrationNumber;
    private String departmentName;
    private String driverName;

    private boolean headofDepartmentApproved;
    private boolean humanResourcesApproved;
    private String currentApprover;
    private String overallStatus;

    // Many-to-one relationship with Driver
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public RequisitionForm(Long requisitionFormId, String destination, LocalTime timeIn, LocalTime timeOut, LocalDate dateIn, LocalDate dateOut, double fuelIn, double fuelOut, int mileageOut, int mileageIn, String purpose, String vehicleRegistrationNumber, String departmentName, String driverName, boolean headofDepartmentApproved, boolean humanResourcesApproved, String currentApprover, String overallStatus, Driver driver) {
        this.requisitionFormId = requisitionFormId;
        this.destination = destination;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.fuelIn = fuelIn;
        this.fuelOut = fuelOut;
        this.mileageOut = mileageOut;
        this.mileageIn = mileageIn;
        this.purpose = purpose;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
        this.departmentName = departmentName;
        this.driverName = driverName;
        this.headofDepartmentApproved = headofDepartmentApproved;
        this.humanResourcesApproved = humanResourcesApproved;
        this.currentApprover = currentApprover;
        this.overallStatus = overallStatus;
        this.driver = driver;
    }

    public RequisitionForm() {
    }

    public Long getRequisitionFormId() {
        return requisitionFormId;
    }

    public void setRequisitionFormId(Long requisitionFormId) {
        this.requisitionFormId = requisitionFormId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public double getFuelIn() {
        return fuelIn;
    }

    public void setFuelIn(double fuelIn) {
        this.fuelIn = fuelIn;
    }

    public double getFuelOut() {
        return fuelOut;
    }

    public void setFuelOut(double fuelOut) {
        this.fuelOut = fuelOut;
    }

    public int getMileageOut() {
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isHeadofDepartmentApproved() {
        return headofDepartmentApproved;
    }

    public void setHeadofDepartmentApproved(boolean headofDepartmentApproved) {
        this.headofDepartmentApproved = headofDepartmentApproved;
    }

    public boolean isHumanResourcesApproved() {
        return humanResourcesApproved;
    }

    public void setHumanResourcesApproved(boolean humanResourcesApproved) {
        this.humanResourcesApproved = humanResourcesApproved;
    }

    public String getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(String currentApprover) {
        this.currentApprover = currentApprover;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "RequisitionForm{" +
                "requisitionFormId=" + requisitionFormId +
                ", destination='" + destination + '\'' +
                ", timeIn=" + timeIn +
                ", timeOut=" + timeOut +
                ", dateIn=" + dateIn +
                ", dateOut=" + dateOut +
                ", fuelIn=" + fuelIn +
                ", fuelOut=" + fuelOut +
                ", mileageOut=" + mileageOut +
                ", mileageIn=" + mileageIn +
                ", purpose='" + purpose + '\'' +
                ", vehicleRegistrationNumber='" + vehicleRegistrationNumber + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", driverName='" + driverName + '\'' +
                ", headofDepartmentApproved=" + headofDepartmentApproved +
                ", humanResourcesApproved=" + humanResourcesApproved +
                ", currentApprover='" + currentApprover + '\'' +
                ", overallStatus='" + overallStatus + '\'' +
                ", driver=" + driver +
                '}';
    }

    public Vehicle getDriverDetails() {
        return null;
    }
}

