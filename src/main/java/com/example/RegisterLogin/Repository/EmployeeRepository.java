package com.example.RegisterLogin.Repository;

import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    // find employee by email
    Employee findByEmail(String email);

    // find employees by role
    List<Employee> findByRole(UserRole role);

    Optional<Employee> findOneByEmailAndPassword(String email, String encodedPassword);
}
