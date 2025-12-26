package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService supplierProfileService;

    @GetMapping("/{id}")
    public ResponseEntity<SupplierProfile> getSupplier(@PathVariable Long id) {
        return ResponseEntity.ok(
                supplierProfileService.getSupplierById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<SupplierProfile>> getAllSuppliers() {
        return ResponseEntity.ok(
                supplierProfileService.getAllSuppliers()
        );
    }

    @PostMapping
    public ResponseEntity<SupplierProfile> createSupplier(
            @RequestBody SupplierProfile supplier) {

        return ResponseEntity.ok(
                supplierProfileService.createSupplier(supplier)
        );
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<SupplierProfile> updateStatus(
            @PathVariable Long id,
            @RequestParam boolean active) {

        return ResponseEntity.ok(
                supplierProfileService.updateSupplierStatus(id, active)
        );
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<SupplierProfile> getByCode(
            @PathVariable String code) {

        Optional<SupplierProfile> supplier =
                supplierProfileService.getBySupplierCode(code);

        return supplier.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
