package com.example.RegisterLogin.Controller;


import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Entity.Vehicle;
import com.example.RegisterLogin.Service.AnomalyDetectionService;
import com.example.RegisterLogin.Service.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleServices vehicleServices;

    @Autowired
    private AnomalyDetectionService anomalyDetectionService;



}
