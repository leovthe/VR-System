package com.example.RegisterLogin.Repository;


import com.example.RegisterLogin.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByMake(String make);
    List<Vehicle> findByType(String type);
}
