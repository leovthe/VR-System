package com.example.RegisterLogin.Repository;


import com.example.RegisterLogin.Entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    // custom method to find drivers by department name
    List<Driver> findByDepartmentName(String departmentName);

    // custom method to find drivers by vehicle preference
    List<Driver> findByVehiclePreference (String vehiclePreference);

    // custom method to find drivers by department name and vehicle preference
    List<Driver> findByDepartmentNameAndVehiclePreference(String departmentName, String vehiclePreference);

}
