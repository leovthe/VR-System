package com.example.RegisterLogin.Service.impl;


import com.example.RegisterLogin.Dto.UpdateRequisitionFormDto;
import com.example.RegisterLogin.Entity.Driver;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Repository.DriverRepository;
import com.example.RegisterLogin.Repository.RequisitionFormRepository;
import com.example.RegisterLogin.Service.RequisitionFormService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequisitionFormServiceImpl implements RequisitionFormService {
    private final RequisitionFormRepository formRepository;
    private final DriverRepository driverRepository;

    public RequisitionFormServiceImpl(RequisitionFormRepository formRepository, DriverRepository driverRepository) {
        this.formRepository = formRepository;
        this.driverRepository = driverRepository;
    }


    @Override
    @PreAuthorize("hasRole('DRIVER')or hasRole('ADMINISTRATOR')")
    public RequisitionForm createForm(RequisitionForm form) {
        // Set initial status and approver
        form.setOverallStatus("CREATED");
        form.setCurrentApprover("Head of Department");


        // Save the driver entity first if it is not null
        if (form.getDriver() != null){
            Driver savedDriver = driverRepository.save(form.getDriver());
            form.setDriver(savedDriver);
        }
        return formRepository.save(form);
    }

    @Override
    public RequisitionForm submitForHODApproval(Long formId) {
        RequisitionForm form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("Form not found"));

        // Check if the form has already been submitted
        if (!form.getOverallStatus().equals("CREATED")) {
            throw new IllegalStateException("Form has already been submitted for approval.");
        }

        // Update form status to 'PENDING_HOD_APPROVAL'
        form.setOverallStatus("PENDING_HOD_APPROVAL");
        return formRepository.save(form);
    }

    @Override
    public RequisitionForm approveByHOD(Long formId) {
        RequisitionForm form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("Form not found"));

        // Check if the form is pending HOD approval
        if (!form.getOverallStatus().equals("PENDING_HOD_APPROVAL")) {
            throw new IllegalStateException("Form is not pending HOD approval.");
        }

        // Update form status to 'PENDING_HR_APPROVAL'
        form.setOverallStatus("PENDING_HR_APPROVAL");
        return formRepository.save(form);
    }

    @Override
    public RequisitionForm approveByHR(Long formId) {
        RequisitionForm form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("Form not found"));

        // Check if the form is pending HR approval
        if (!form.getOverallStatus().equals("PENDING_HR_APPROVAL")) {
            throw new IllegalStateException("Form is not pending HR approval.");
        }

        //update the current approver to'HR'
        form.setCurrentApprover("HR");

        // Update form status to 'APPROVED'
        form.setOverallStatus("APPROVED");
        return formRepository.save(form);
    }

    @Override
    public RequisitionForm rejectByHOD(Long formId) {
        RequisitionForm form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("Form not found"));

        // Check if the form is pending HR approval
        if (!form.getOverallStatus().equals("PENDING_HOD_APPROVAL")) {
            throw new IllegalStateException("Form is not pending HR approval.");
        }

        // Update form status to 'REJECTED'
        form.setOverallStatus("REJECTED");
        return formRepository.save(form);
    }

    @Override
    public RequisitionForm rejectByHR(Long formId) {
        RequisitionForm form = formRepository.findById(formId)
                .orElseThrow(() -> new IllegalArgumentException("Form not found"));

        // Check if the form is pending HR approval
        if (!form.getOverallStatus().equals("PENDING_HR_APPROVAL")) {
            throw new IllegalStateException("Form is not pending HR approval.");
        }

        // Update form status to 'REJECTED'
        form.setOverallStatus("REJECTED");
        return formRepository.save(form);
    }


    @Override
    public List<RequisitionForm> getRequisitionForms() {
        return formRepository.findAll();
    }

    @Override
    public RequisitionForm updateForm(Long formId, UpdateRequisitionFormDto updatedFormDto) {
        // Retrieve existing requisition form from database
        Optional<RequisitionForm> optionalForm = formRepository.findById(formId);
        if (!optionalForm.isPresent()) {
            throw new IllegalArgumentException("RequisitionForm with id " + formId + " not found.");
        }

        RequisitionForm existingForm = optionalForm.get();

        // Update fields based on updatedFormDto
        existingForm.setTimeIn(updatedFormDto.getTimeIn());
        existingForm.setDateIn(updatedFormDto.getDateIn());
        existingForm.setFuelIn(updatedFormDto.getFuelIn());
        existingForm.setMileageIn(updatedFormDto.getMileageIn());

        // Update any other fields as needed

        // Save updated form back to database
        return formRepository.save(existingForm);
    }




    @Override
    // Method to fetch all forms
    public List<RequisitionForm> getAllForms() {
        return formRepository.findAll();
    }

    @Override
    public RequisitionForm getFormById(Long formId) {
        Optional<RequisitionForm> optionalForm = formRepository.findById(formId);
        if (optionalForm.isPresent()) {
            return optionalForm.get();
        } else {
            throw new IllegalArgumentException("RequisitionForm with id " + formId + " not found.");
        }
    }

}

