package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository riskAlertRepository;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository riskAlertRepository) {
        this.riskAlertRepository = riskAlertRepository;
    }

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        if (alert.getResolved() == null) {
            alert.setResolved(false);   // ✔ default resolved = false
        }
        return riskAlertRepository.save(alert);
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return riskAlertRepository.findBySupplierId(supplierId);
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long alertId) {
        SupplierRiskAlert alert = riskAlertRepository.findById(alertId)
                .orElseThrow(() -> new BadRequestException("Alert not found"));
        alert.setResolved(true);       // ✔ flag changed
        return riskAlertRepository.save(alert);
    }

    // ✅ FIXED: repository-level filtering
    @Override
    public List<SupplierRiskAlert> getAlertsByLevel(String level) {
        if (level == null) {
            return List.of();
        }
        return riskAlertRepository
                .findByAlertLevelContainingIgnoreCase(level);
    }

    // ✅ FIXED: unresolved alerts via repository
    @Override
    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return riskAlertRepository.findByResolvedFalse();
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return riskAlertRepository.findAll();
    }
}
