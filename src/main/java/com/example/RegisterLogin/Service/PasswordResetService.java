package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Entity.PasswordResetToken;
import com.example.RegisterLogin.Repository.EmployeeRepository;
import com.example.RegisterLogin.Repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private PasswordResetTokenRepository tokenRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createPasswordResetTokenForEmployee(Employee employee) {
        try {
            String token = UUID.randomUUID().toString();
            PasswordResetToken myToken = new PasswordResetToken(token, employee);
            tokenRepository.save(myToken);
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Error generating password reset token", e);
        }
    }

    public Employee getEmployeeByPasswordResetToken(String token) {
        try {
            PasswordResetToken passToken = tokenRepository.findByToken(token);
            if (passToken == null) {
                throw new RuntimeException("Token not found");
            }
            Calendar cal = Calendar.getInstance();
            if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
                throw new RuntimeException("Token expired");
            }
            return passToken.getEmployee();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving employee by token", e);
        }
    }

    public void changeEmployeePassword(Employee employee, String newPassword) {
        try {
            employee.setPassword(passwordEncoder.encode(newPassword));
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Error changing employee password", e);
        }
    }

    public Employee getEmployeeByEmail(String email) {
        try {
            return employeeRepository.findByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving employee by email", e);
        }
    }
}
