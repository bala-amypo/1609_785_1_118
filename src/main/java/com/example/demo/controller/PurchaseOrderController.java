package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderRecordRepository poRepo;

    @PostMapping("/PO")
    public PurchaseOrderRecord createPO(@RequestBody PurchaseOrderRecord po) {
        return poRepo.save(po);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getPOsBySupplier(@PathVariable Long supplierId) {
        return poRepo.findBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getPO(@PathVariable Long id) {
        return poRepo.findById(id).orElseThrow();
    }

    @GetMapping("/POR")
    public List<PurchaseOrderRecord> listAll() {
        return poRepo.findAll();
    }
}