package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;

@RestController
@RequestMapping("/api/risk-alerts")
public class SupplierRiskAlertController {

    private SupplierRiskAlertRepository repo;

    public SupplierRiskAlertController(SupplierRiskAlertRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public SupplierRiskAlert create(@RequestBody SupplierRiskAlert alert) {
        alert.setAlertDate(LocalDateTime.now());
        alert.setResolved(false);
        return repo.save(alert);
    }
    @PutMapping("/{id}/resolve")
    public SupplierRiskAlert resolve(@PathVariable Long id) {
        SupplierRiskAlert a = repo.findById(id).orElse(null);
        if (a != null) {
            a.setResolved(true);
            repo.save(a);
        }
        return a;
    }
    @GetMapping("/supplier/{supplierId}")
    public List<SupplierRiskAlert> getBySupplier(@PathVariable Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public SupplierRiskAlert getOne(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping
    public List<SupplierRiskAlert> getAll() {
        return repo.findAll();
    }
}
