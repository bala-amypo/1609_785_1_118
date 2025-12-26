package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertService alertService;

    @PostMapping
    public ResponseEntity<SupplierRiskAlert> createAlert(@RequestBody SupplierRiskAlert alert) {
        return ResponseEntity.ok(alertService.createAlert(alert));
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<SupplierRiskAlert>> getAlertsBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(alertService.getAlertsBySupplier(supplierId));
    }

    @PutMapping("/{alertId}/resolve")
    public ResponseEntity<SupplierRiskAlert> resolveAlert(@PathVariable Long alertId) {
        return ResponseEntity.ok(alertService.resolveAlert(alertId));
    }
}
