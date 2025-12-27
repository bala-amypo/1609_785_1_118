package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final SupplierRiskAlertRepository riskAlertRepository;

    public SupplierRiskAlertServiceImpl(SupplierRiskAlertRepository riskAlertRepository) {
        this.riskAlertRepository = riskAlertRepository;
    }

    /**
     * Create a new alert
     * Default resolved = false
     */
    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        if (alert.getResolved() == null) {
            alert.setResolved(false);
        }
        return riskAlertRepository.save(alert);
    }

    /**
     * Get all alerts for a specific supplier
     * Supports multiple alerts per supplier
     */
    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return riskAlertRepository.findBySupplierId(supplierId);
    }

    /**
     * Resolve an alert by ID
     * Sets resolved = true
     */
    @Override
    public SupplierRiskAlert resolveAlert(Long alertId) {
        SupplierRiskAlert alert = riskAlertRepository.findById(alertId)
                .orElseThrow(() -> new BadRequestException("Alert not found"));
        alert.setResolved(true);
        return riskAlertRepository.save(alert);
    }

    /**
     * Get all alerts in the system
     */
    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return riskAlertRepository.findAll();
    }

    /**
     * LIKE-based alert level filtering
     * Fixes:
     * - testCriteriaLikeHighRiskSuppliers
     * - testCriteriaAlertMediumRisk
     */
    public List<SupplierRiskAlert> getAlertsByLevel(String level) {
        return riskAlertRepository.findAll().stream()
                .filter(a ->
                        a.getAlertLevel() != null &&
                        a.getAlertLevel().toUpperCase().contains(level.toUpperCase())
                )
                .collect(Collectors.toList());
    }

    /**
     * Get unresolved alerts only
     * Fixes testCriteriaLikeUnresolvedAlerts
     */
    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return riskAlertRepository.findAll().stream()
                .filter(a -> Boolean.FALSE.equals(a.getResolved()))
                .collect(Collectors.toList());
    }
}
