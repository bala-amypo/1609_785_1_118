package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertService alertService;

    @PostMapping("/")
    public SupplierRiskAlert createAlert(@RequestBody SupplierRiskAlert alert) {
        return alertService.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolveAlert(@PathVariable Long id) {
        alertService.resolveAlert(id);
        return alertService.getAlertById(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> getAlertsBySupplier(@PathVariable Long supplierId) {
        return alertService.getAlertsBySupplier(supplierId);
    }

    @GetMapping("/{id}")
    public SupplierRiskAlert getAlert(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    @GetMapping("/")
    public List<SupplierRiskAlert> listAll() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/unresolved")
    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return alertService.getUnresolvedAlerts();
    }
}
