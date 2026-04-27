package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Entity.RequisitionForm;
import com.example.RegisterLogin.Repository.RequisitionFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnomalyDetectionService {

    @Autowired
    private RequisitionFormRepository requisitionFormRepository;

    public List<RequisitionForm> detectAnomalies() {
        List<RequisitionForm> requisitionForms = requisitionFormRepository.findAll();

        Map<String, List<Integer>> formsByDestination = new HashMap<>();
        Map<String, Integer> initialDifferences = new HashMap<>();
        List<RequisitionForm> anomalies = new ArrayList<>();

        // Group forms by destination and calculate initial differences
        for (RequisitionForm form : requisitionForms) {
            String destination = form.getDestination();
            int difference = form.getMileageIn() - form.getMileageOut();

            if (!formsByDestination.containsKey(destination)) {
                formsByDestination.put(destination, new ArrayList<>());
                initialDifferences.put(destination, difference);
            }

            formsByDestination.get(destination).add(difference);
        }

        // Detect anomalies
        for (Map.Entry<String, List<Integer>> entry : formsByDestination.entrySet()) {
            String destination = entry.getKey();
            List<Integer> differences = entry.getValue();
            int initialDifference = initialDifferences.get(destination);

            for (int difference : differences) {
                if (Math.abs(difference - initialDifference) > 15) {
                    for (RequisitionForm form : requisitionForms) {
                        if (form.getDestination().equals(destination) &&
                                (form.getMileageIn() - form.getMileageOut()) == difference) {
                            anomalies.add(form);
                        }
                    }
                }
            }
        }

        return anomalies;
    }
}
