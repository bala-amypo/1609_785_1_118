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
        return alertRepo.save(alert);
    }

    // ✅ RETURN TYPE FIXED
    @Override
    public SupplierRiskAlert resolveAlert(Long id) {
        SupplierRiskAlert alert = alertRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found with id: " + id));

        alert.setResolved(true);
        return alertRepo.save(alert);
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return alertRepo.findBySupplierId(supplierId);
    }

    // (Optional but correct)
    public List<SupplierRiskAlert> getAllAlerts() {
        return alertRepo.findAll();
    }

    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return alertRepo.findByResolved(false);
    }

    public SupplierRiskAlert getAlertById(Long id) {
        return alertRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alert not found with id: " + id));
    }
}
