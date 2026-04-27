package com.example.RegisterLogin.Controller;


import com.example.RegisterLogin.Dto.RequisitionFormDto;
import com.example.RegisterLogin.Dto.UpdateRequisitionFormDto;
import com.example.RegisterLogin.Entity.Driver;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Entity.Vehicle;
import com.example.RegisterLogin.Service.AnomalyDetectionService;
import com.example.RegisterLogin.Service.RequisitionFormService;
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
@RequestMapping("/api/v1/requisitionForms")
public class RequisitionFormController {

    @Autowired
    private AnomalyDetectionService anomalyDetectionService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public RequisitionFormController(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private  RequisitionFormService formService;

    public RequisitionFormController(RequisitionFormService formService) {
        this.formService = formService;
    }

    @GetMapping("/requisition-form")
    public String showRequisitionForm(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Requisition.form.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @GetMapping("/submit-form")
    public String submitRequisitionForm(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Submit.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @GetMapping("/anomaly")
    public String showAnomalyForm(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Anomaly.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }




    @PostMapping("/createForm")
    public ResponseEntity<RequisitionForm> createRequisitionForm(@RequestBody RequisitionFormDto formDTO) {
        // Convert DTO to entity
        RequisitionForm form = new RequisitionForm();
        form.setDestination(formDTO.getDestination());
        form.setTimeIn(formDTO.getTimeIn());
        form.setTimeOut(formDTO.getTimeOut());
        form.setDateIn(formDTO.getDateIn());
        form.setDateOut(formDTO.getDateOut());
        form.setFuelIn(formDTO.getFuelIn());
        form.setFuelOut(formDTO.getFuelOut());
        form.setMileageOut(formDTO.getMileageOut());
        form.setMileageIn(formDTO.getMileageIn());
        form.setPurpose(formDTO.getPurpose());
        form.setVehicleRegistrationNumber(formDTO.getVehicleRegistrationNumber());
        form.setDepartmentName(formDTO.getDepartmentName());
        form.setDriverName(formDTO.getDriverName());
        form.setOverallStatus("CREATED");
        form.setCurrentApprover("Head of Department");


        // Set driver information
        Driver driver = new Driver();
        driver.setName(formDTO.getDriverName());
        form.setDriver(driver);


        // Create requisition form
        RequisitionForm createdForm = formService.createForm(form);


        // Return the created form in the response
        return new ResponseEntity<>(createdForm, HttpStatus.CREATED);
    }

    // Endpoint for submitting requisition form for HOD approval
    @PostMapping("/{formId}/submitForHODApproval")
    public ResponseEntity<RequisitionForm> submitForHODApproval(@PathVariable Long formId) {
        RequisitionForm submittedForm = formService.submitForHODApproval(formId);

        return new ResponseEntity<>(submittedForm, HttpStatus.OK);
    }

    @PutMapping("/{formId}/approveByHOD")
    public ResponseEntity<RequisitionForm> approveByHOD(@PathVariable Long formId) {
        RequisitionForm approvedForm = formService.approveByHOD(formId);
        return new ResponseEntity<>(approvedForm, HttpStatus.OK);
    }

    @PutMapping("/{formId}/approveByHR")
    public ResponseEntity<RequisitionForm> approveByHR(@PathVariable Long formId) {
        RequisitionForm approvedForm = formService.approveByHR(formId);
        return new ResponseEntity<>(approvedForm, HttpStatus.OK);
    }

    @PutMapping("/{formId}/rejectByHOD")
    public ResponseEntity<RequisitionForm> rejectByHOD(@PathVariable Long formId) {
        RequisitionForm rejectedForm = formService.rejectByHOD(formId);
        return new ResponseEntity<>(rejectedForm, HttpStatus.OK);
    }

    @PutMapping("/{formId}/rejectByHR")
    public ResponseEntity<RequisitionForm> rejectByHR(@PathVariable Long formId) {
        RequisitionForm rejectedForm = formService.rejectByHR(formId);
        return new ResponseEntity<>(rejectedForm, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RequisitionForm>> getAllRequisitionForms() {
        // Fetch all requisition forms from the service
        List<RequisitionForm> requisitionForms = formService.getAllForms();

        // Return the list of requisition forms in the response
        return new ResponseEntity<>(requisitionForms, HttpStatus.OK);
    }
    @GetMapping("/requisitionForms")
    public ResponseEntity<List<RequisitionForm>> getRequisitionForms() {

        // Call the service method to retrieve requisition forms from the database
        List<RequisitionForm> requisitionForms = formService.getRequisitionForms();
        return new ResponseEntity<>(requisitionForms, HttpStatus.OK);
    }

    @GetMapping("/detectAnomalies")
    public ResponseEntity<List<RequisitionForm>> detectAnomalies() {
        List<RequisitionForm> anomalies = anomalyDetectionService.detectAnomalies();

        return new ResponseEntity<>(anomalies, HttpStatus.OK);
    }

    // Endpoint to update requisition form details
    @PutMapping("/{formId}")
    public ResponseEntity<RequisitionForm> updateRequisitionForm(
            @PathVariable Long formId,
            @RequestBody UpdateRequisitionFormDto updatedFormDto) {

        RequisitionForm updatedForm = formService.updateForm(formId, updatedFormDto);
        return new ResponseEntity<>(updatedForm, HttpStatus.OK);
    }



}
