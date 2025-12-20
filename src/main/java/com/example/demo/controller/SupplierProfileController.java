package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    @Autowired
    private SupplierProfileService supplierService;

    @PostMapping("/")
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return supplierService.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getSupplier(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping("/")
    public List<SupplierProfile> listAll() {
        return supplierService.getAllSuppliers();
    }

    @PutMapping("/{id}/status")
    public SupplierProfile updateStatus(
            @PathVariable Long id,
            @RequestBody Boolean status) {

        return supplierService.updateSupplierStatus(id, status);
    }

    @GetMapping("/lookup/{supplierCode}")
    public SupplierProfile lookupByCode(@PathVariable String supplierCode) {
        return supplierService.getBySupplierCode(supplierCode);
    }
}
