package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
public class SupplierRiskAlertController {

    @Autowired
    private SupplierRiskAlertRepository alertRepo;

    @PostMapping("/")
    public SupplierRiskAlert createAlert(@RequestBody SupplierRiskAlert alert) {
        return alertRepo.save(alert);
    }

    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolveAlert(@PathVariable Long id) {
        SupplierRiskAlert alert = alertRepo.findById(id).orElseThrow();
        alert.setResolved(true);   // ✅ FIXED
        return alertRepo.save(alert);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> getAlertsBySupplier(@PathVariable Long supplierId) {
        return alertRepo.findBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public SupplierRiskAlert getAlert(@PathVariable Long id) {
        return alertRepo.findById(id).orElseThrow();
    }

    @GetMapping("/")
    public List<SupplierRiskAlert> listAll() {
        return alertRepo.findAll();
    }
}
