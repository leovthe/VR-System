package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Service.EmailService;
import com.example.RegisterLogin.Service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/v1/password")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public PasswordResetController(ResourceLoader resourceLoader){this.resourceLoader = resourceLoader;}

    @Autowired
    private EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(PasswordResetController.class);


    @GetMapping("/reset-page")
    public String showResetPage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Reset.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @GetMapping("/change-page")
    public String showChangePage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Change.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @PostMapping("/reset")
    public Map<String, String> resetPassword(@RequestParam String email) {
        Map<String, String> response = new HashMap<>();
        try {
            Employee employee = passwordResetService.getEmployeeByEmail(email);
            if (employee == null) {
                response.put("message", "Employee not found");
                return response;
            }
            String token = passwordResetService.createPasswordResetTokenForEmployee(employee);
            emailService.sendPasswordResetEmail(employee.getEmail(), token); // Send email with reset token
            response.put("message", "Password reset email sent");
        } catch (Exception e) {
            logger.error("Error occurred while resetting password: ", e);
            response.put("message", "An error occurred while resetting password");
        }
        return response;
    }


    @PostMapping("/change")
    public Map<String, String> changePassword(@RequestParam String token, @RequestParam String newPassword) {
        Map<String, String> response = new HashMap<>();
        try {
            Employee employee = passwordResetService.getEmployeeByPasswordResetToken(token);
            if (employee == null) {
                response.put("message", "Invalid token");
                return response;
            }
            passwordResetService.changeEmployeePassword(employee, newPassword);
            response.put("message", "Password changed successfully");
        } catch (Exception e) {
            logger.error("Error occurred while changing password: ", e);
            response.put("message", "An error occurred while changing password");
        }
        return response;
    }
}
