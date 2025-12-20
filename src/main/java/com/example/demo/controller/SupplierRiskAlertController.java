package com.example.demo.controller;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/risk-alerts")
@Tag(name = "SupplierRiskAlertController")
public class SupplierRiskAlertController {
    @Autowired
    private SupplierRiskAlertService service;

    @PostMapping
    public SupplierRiskAlert create(@RequestBody SupplierRiskAlert alert) {
        return service.createAlert(alert);
    }

    @PutMapping("/{id}/resolve")
    public void resolve(@PathVariable Long id) {
        service.resolveAlert(id);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> getBySupplier(@PathVariable Long supplierId) {
        return service.getActiveAlertsBySupplier(supplierId);
    }
}