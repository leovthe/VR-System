package com.example.RegisterLogin.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


import java.util.List;


@Entity
public class Driver {
    @Id
    @GeneratedValue
    private Long driverId;
    private String driverName;
    private String departmentName;
    private String vehiclePreference;

// one-to-many relationship with RequisitionForm
    @OneToMany(mappedBy = "driver")
    private List<RequisitionForm> requisitionForms;

    public Driver(Long driverId, String driverName, String departmentName, String vehiclePreference, List<RequisitionForm> requisitionForms) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.departmentName = departmentName;
        this.vehiclePreference = vehiclePreference;
        this.requisitionForms = requisitionForms;
    }

    public Driver() {
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", vehiclePreference='" + vehiclePreference + '\'' +
                ", requisitionForms=" + requisitionForms +
                '}';
    }

    public void setId(Long driverId) {
    }

    public void setName(String driverName) {
    }

    public void setLicenseNumber(String driverLicenseNumber) {
    }
}
