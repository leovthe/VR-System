package com.example.RegisterLogin.Repository;


import com.example.RegisterLogin.Entity.RequisitionForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RequisitionFormRepository extends JpaRepository<RequisitionForm, Long> {

    List<RequisitionForm> findByDepartmentName(String departmentName);
    List<RequisitionForm> findByDestination(String destination);
    List<RequisitionForm> findByDateInBetween(LocalDate startDate, LocalDate endDate);
    List<RequisitionForm> findAll();

}
