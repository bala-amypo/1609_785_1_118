package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileRepository supplierRepo;

    @PostMapping("/")
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return supplierRepo.save(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplier(@PathVariable Long id) {
        return supplierRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
    }

    @GetMapping("/")
    public List<SupplierProfile> listAll() {
        return supplierRepo.findAll();
    }

    @PutMapping("/{id}/status")
    public SupplierProfile updateStatus(@PathVariable Long id, @RequestBody Boolean status) {
        SupplierProfile supplier = supplierRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setActive(status);
        return supplierRepo.save(supplier);
    }

    @GetMapping("/lookup/{supplierCode}")
    public SupplierProfile lookupByCode(@PathVariable String supplierCode) {
        return supplierRepo.findBySupplierCode(supplierCode);
    }
}
