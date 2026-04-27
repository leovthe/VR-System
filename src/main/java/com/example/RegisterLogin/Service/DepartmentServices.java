package com.example.RegisterLogin.Service;


import com.example.RegisterLogin.Entity.Department;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Repository.DepartmentRepository;
import com.example.RegisterLogin.Repository.RequisitionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServices {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RequisitionFormRepository requisitionFormRepository;

    // CRUD operations

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<RequisitionForm> getRequisitionForms() {return requisitionFormRepository.findAll();}
}
