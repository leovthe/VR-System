package com.example.RegisterLogin.Service;


import com.example.RegisterLogin.Entity.Vehicle;
import com.example.RegisterLogin.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServices {

    @Autowired
    private VehicleRepository vehicleRepository;

    // Crud operations

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public void saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public void deleteVehicleById(Long id) {
        vehicleRepository.deleteById(id);
    }
}
