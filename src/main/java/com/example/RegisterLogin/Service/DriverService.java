package com.example.RegisterLogin.Service;


import com.example.RegisterLogin.Entity.Driver;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Repository.DriverRepository;
import com.example.RegisterLogin.Repository.RequisitionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RequisitionFormRepository requisitionFormRepository;


    // CRUD operations

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<RequisitionForm> getRequisitionForms() {
        return requisitionFormRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    public void saveDriver(Driver driver) {
        driverRepository.save(driver);
    }

    public void deleteDriverById(Long id) {
        driverRepository.deleteById(id);
    }

}
