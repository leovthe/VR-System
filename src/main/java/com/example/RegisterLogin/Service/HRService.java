package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.HR;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Repository.HrRepository;
import com.example.RegisterLogin.Repository.RequisitionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRService {

    @Autowired
    private HrRepository hrRepository;

    @Autowired
    private RequisitionFormRepository requisitionFormRepository;

    public List<HR> getAllHRUsers() {return hrRepository.findAll();}

    public List<RequisitionForm> getRequisitionForms() {return requisitionFormRepository.findAll();}
}
