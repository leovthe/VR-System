package com.example.RegisterLogin.Service.impl;

import com.example.RegisterLogin.Dto.EmployeeDto;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repository.EmployeeRepository;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.Response.LoginResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpSession session;

    @Override
    public String addEmployee(EmployeeDto employeeDTO) {
        Employee employee = new Employee();
        employee.setEmployeename(employeeDTO.getEmployeename());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
        employee.setRole(employeeDTO.getRole());
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findByEmail(email);
        if (employee == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(employee.getEmail())
                .password(employee.getPassword())
                .roles(String.valueOf(employee.getRole()))
                .build();
    }

    @Override
    public LoginResponse loginEmployee(LoginDto loginDTO) {
        Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());
        if (employee != null) {
            if (passwordEncoder.matches(loginDTO.getPassword(), employee.getPassword())) {
                String role = employee.getRole().name(); // Get the enum name
                if (employee.getRole() == loginDTO.getRole()) {
                    return new LoginResponse("Login Success", true, role);
                } else {
                    return new LoginResponse("Role Mismatch", false);
                }
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

    @Override
    public LoginResponse logout() {
        session.invalidate(); // Invalidate the user's session
        return new LoginResponse("Logout Successful", true);
    }
}
