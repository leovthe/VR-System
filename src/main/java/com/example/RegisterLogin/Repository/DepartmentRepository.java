package com.example.RegisterLogin.Repository;


import com.example.RegisterLogin.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByDepartmentHead(String departmentHead);
}
