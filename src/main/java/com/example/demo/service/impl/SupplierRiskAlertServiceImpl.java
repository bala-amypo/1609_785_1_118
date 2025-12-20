package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    @Autowired
    private SupplierRiskAlertRepository alertRepo;

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        // Requirement: Save a new risk alert
        return alertRepo.save(alert);
    }

    @Override
    public void resolveAlert(Long id) {
        // Requirement: Logic to change alert status to "RESOLVED"
        SupplierRiskAlert alert = alertRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Alert not found"));
        alert.setStatus("RESOLVED");
        alertRepo.save(alert);
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        // Requirement: Get all alerts for a specific supplier
        return alertRepo.findBySupplierId(supplierId);
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        // Requirement: List all alerts in the system
        return alertRepo.findAll();
    }
}