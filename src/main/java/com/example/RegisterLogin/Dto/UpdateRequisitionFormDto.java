package com.example.RegisterLogin.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdateRequisitionFormDto {
    private LocalTime timeIn;
    private LocalDate dateIn;
    private double fuelIn;
    private int mileageIn;

    public UpdateRequisitionFormDto(LocalTime timeIn, LocalDate dateIn, double fuelIn, int mileageIn) {
        this.timeIn = timeIn;
        this.dateIn = dateIn;
        this.fuelIn = fuelIn;
        this.mileageIn = mileageIn;
    }

    public UpdateRequisitionFormDto() {
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public double getFuelIn() {
        return fuelIn;
    }

    public void setFuelIn(double fuelIn) {
        this.fuelIn = fuelIn;
    }

    public int getMileageIn() {
        return mileageIn;
    }

    public void setMileageIn(int mileageIn) {
        this.mileageIn = mileageIn;
    }

    @Override
    public String toString() {
        return "UpdateRequisitionFormDto{" +
                "timeIn=" + timeIn +
                ", dateIn=" + dateIn +
                ", fuelIn=" + fuelIn +
                ", mileageIn=" + mileageIn +
                '}';
    }
}
