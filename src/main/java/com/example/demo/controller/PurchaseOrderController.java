package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {
    private PurchaseOrderRecordRepository repo;

    public PurchaseOrderController(PurchaseOrderRecordRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public PurchaseOrderRecord createPO(@RequestBody PurchaseOrderRecord po) {
        return repo.save(po);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getBySupplier(@PathVariable Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getPO(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping
    public List<PurchaseOrderRecord> getAll() {
        return repo.findAll();
    }
}
