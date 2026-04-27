package com.example.RegisterLogin.Controller;


import com.example.RegisterLogin.Entity.Driver;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/drivers")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    public DriverController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/user-driver")
    public String showDriverPage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/User.driver.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Driver driver = driverService.getDriverById(id);
        if (driver != null) {
            return new ResponseEntity<>(driver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver) {
        driverService.saveDriver(driver);
        return new ResponseEntity<>(driver, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriverById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/requisitionForms")
    public ResponseEntity<List<RequisitionForm>> getRequisitionForms() {

        // Call the service method to retrieve requisition forms from the database
        List<RequisitionForm> requisitionForms = driverService.getRequisitionForms();
        return new ResponseEntity<>(requisitionForms, HttpStatus.OK);
    }


}
