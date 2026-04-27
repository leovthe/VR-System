package com.example.RegisterLogin.Controller;


import com.example.RegisterLogin.Entity.Department;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Service.DepartmentServices;
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
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public DepartmentController(ResourceLoader resourceLoader){this.resourceLoader = resourceLoader;}

    @GetMapping("/department-page")
    public String showDepartmentPage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/User.dept.head.html");
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
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentServices.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Department department = departmentServices.getDepartmentById(id);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        departmentServices.saveDepartment(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentServices.deleteDepartmentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/requisitionForms")
    public ResponseEntity<List<RequisitionForm>> getRequisitionForms() {

        // Call the service method to retrieve requisition forms from the database
        List<RequisitionForm> requisitionForms = departmentServices.getRequisitionForms();
        return new ResponseEntity<>(requisitionForms, HttpStatus.OK);
    }
}
