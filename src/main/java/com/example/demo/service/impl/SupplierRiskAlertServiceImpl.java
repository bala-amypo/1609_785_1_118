package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final List<SupplierRiskAlert> alerts = new ArrayList<>();

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        if (alert.getResolved() == null) {
            alert.setResolved(false);
        }
        alerts.add(alert);
        return alert;
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return alerts.stream()
                .filter(a -> a.getSupplierId().equals(supplierId))
                .collect(Collectors.toList());
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long alertId) {
        SupplierRiskAlert alert = alerts.stream()
                .filter(a -> a.getId().equals(alertId))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Alert not found"));

        alert.setResolved(true);
        return alert;
    }

    @Override
    public List<SupplierRiskAlert> getAlertsByLevel(String level) {
        if (level == null) return List.of();

        return alerts.stream()
                .filter(a -> a.getAlertLevel() != null &&
                        a.getAlertLevel().toLowerCase().contains(level.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return alerts.stream()
                .filter(a -> Boolean.FALSE.equals(a.getResolved()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return new ArrayList<>(alerts);
    }
}
