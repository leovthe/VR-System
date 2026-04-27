package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.UpdateRequisitionFormDto;
import com.example.RegisterLogin.Entity.RequisitionForm;

import java.util.List;

public interface RequisitionFormService {
    RequisitionForm createForm(RequisitionForm form);
    
    RequisitionForm submitForHODApproval(Long formId);

    RequisitionForm approveByHOD(Long formId);

    RequisitionForm approveByHR(Long formId);

    RequisitionForm rejectByHOD(Long formId);

    RequisitionForm rejectByHR(Long formId);

    List<RequisitionForm> getAllForms();

    List<RequisitionForm> getRequisitionForms();

    RequisitionForm updateForm(Long formId, UpdateRequisitionFormDto updatedFormDto);

    // Method to fetch a form by ID
    RequisitionForm getFormById(Long formId);
}
