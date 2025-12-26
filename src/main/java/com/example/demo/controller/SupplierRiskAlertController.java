package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertService alertService;

    @PostMapping
    public SupplierRiskAlert createAlert(@RequestBody SupplierRiskAlert alert) {
        return alertService.createAlert(alert);
    }

    @GetMapping
    public List<SupplierRiskAlert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> getAlertsBySupplier(@PathVariable Long supplierId) {
        return alertService.getAlertsBySupplier(supplierId);
    }

    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolveAlert(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }
}
