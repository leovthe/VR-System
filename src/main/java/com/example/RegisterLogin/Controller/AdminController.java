package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.Admin;
import com.example.RegisterLogin.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public AdminController(ResourceLoader resourceLoader){this.resourceLoader = resourceLoader;}

    @GetMapping("/admin-page")
    public String showAdminPage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/User.admin.html");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            StringBuilder content = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                content.append((char) c);
            }
            return content.toString();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdminUser(@RequestBody Admin adminUser) {
        // Check if the user already exists
        if (adminService.findByEmail(adminUser.getEmail()) != null) {
            return new ResponseEntity<>("User with this email already exists.", HttpStatus.BAD_REQUEST);
        }

        // Encode the password before saving
        adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));

        // Save the admin user
        Admin savedUser = adminService.save(adminUser);

        // Return the saved user's details
        return ResponseEntity.ok("User registered successfully. ID: " + savedUser.getId());
    }

    // Add additional endpoints as needed


}
