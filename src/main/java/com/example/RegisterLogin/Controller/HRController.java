package com.example.RegisterLogin.Controller;

import com.example.RegisterLogin.Entity.HR;
import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hr")
public class HRController {

    @Autowired
    private HRService hrService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    public HRController(ResourceLoader resourceLoader){this.resourceLoader = resourceLoader;}

    @GetMapping("/hr-page")
    public String showHrPage(Model model) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/templates/User.hr.html");
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
    public List<HR> getAllHRUsers() {
        return hrService.getAllHRUsers();
    }

    @GetMapping("/requisitionForms")
    public ResponseEntity<List<RequisitionForm>> getRequisitionForms() {

        // Call the service method to retrieve requisition forms from the database
        List<RequisitionForm> requisitionForms = hrService.getRequisitionForms();
        return new ResponseEntity<>(requisitionForms, HttpStatus.OK);
    }
}
