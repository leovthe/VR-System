package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Dto.EmployeeDto;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.Response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public EmployeeController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Employee Register.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @GetMapping("/employee-login")
    public String showLoginPage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/Employee Login.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @PostMapping(path = "/save")
    // Granting access to the ADMINISTRATOR
    @PreAuthorize("hasRole('ADMINISTRATOR')")
    public String saveEmployee(@RequestBody EmployeeDto employeeDTO) {
        String id;
        id = employeeService.addEmployee(employeeDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> LoginEmployee(@RequestBody LoginDto loginDTO) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        // Check if login was successful
        if (loginResponse.isSuccess()) {
            // Check the role in the login response
            String role = loginResponse.getRole();

            // Redirect the user based on the role
            switch (role) {
                case "ADMINISTRATOR":
                    return ResponseEntity.ok().header("Location", "/api/v1/admin").body(loginResponse);
                case "HEAD_OF_DEPARTMENT":
                    return ResponseEntity.ok().header("Location", "/api/v1/departments/department-page").body(loginResponse);
                case "DRIVER":
                    return ResponseEntity.ok().header("Location", "/api/v1/drivers/user-driver").body(loginResponse);
                case "HUMAN_RESOURCES":
                    return ResponseEntity.ok().header("Location", "/api/v1/hr/hr-page").body(loginResponse);
                default:
                    return ResponseEntity.ok().header("Location", "/api/v1/unknown-role").body(loginResponse);
            }
        } else {
            // Handle unsuccessful login
            return ResponseEntity.badRequest().body(loginResponse);
        }
    }

    // Endpoint for logout
    @PostMapping(path = "/logout")
    public LoginResponse logout() {
        return employeeService.logout();
    }
}
