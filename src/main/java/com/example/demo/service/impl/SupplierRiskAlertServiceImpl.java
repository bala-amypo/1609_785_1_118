package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.exception.BadRequestException;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {
    private static final List<SupplierRiskAlert> alerts = new ArrayList<>();
    private static final AtomicLong idCounter = new AtomicLong(1);

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        if (alert.getId() == null) {
            alert.setId(idCounter.getAndIncrement());
        }
        if (alert.getResolved() == null) {
            alert.setResolved(false);
        }
        alerts.add(alert);
        return alert;
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return alerts.stream()
                .filter(a -> a.getSupplierId() != null && a.getSupplierId().equals(supplierId))
                .collect(Collectors.toList());
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long alertId) {
        SupplierRiskAlert alert = alerts.stream()
                .filter(a -> a.getId() != null && a.getId().equals(alertId))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Alert not found"));
        alert.setResolved(true);
        return alert;
    }

    @Override
    public List<SupplierRiskAlert> getAlertsByLevel(String level) {
        if (level == null) return List.of();
        String search = level.toLowerCase();
        return alerts.stream()
                .filter(a -> a.getAlertLevel() != null && a.getAlertLevel().toLowerCase().contains(search))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return alerts.stream()
                .filter(a -> a.getResolved() == null || Boolean.FALSE.equals(a.getResolved()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return new ArrayList<>(alerts);
    }
}
