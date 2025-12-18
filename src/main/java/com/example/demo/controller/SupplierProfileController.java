package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    private SupplierProfileRepository repo;

    public SupplierProfileController(SupplierProfileRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public SupplierProfile createSupplier(@RequestBody SupplierProfile supplier) {
        return repo.save(supplier);
    }
    @GetMapping("/{id}")
    public SupplierProfile getSupplier(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
    @GetMapping
    public List<SupplierProfile> getAllSuppliers() {
        return repo.findAll();
    }
    @PutMapping("/{id}/status")
    public SupplierProfile updateStatus(@PathVariable Long id,
                                        @RequestParam String status) {
        SupplierProfile s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setStatus(status);
            repo.save(s);
        }
        return s;
    }
    @GetMapping("/lookup/{supplierCode}")
    public SupplierProfile lookup(@PathVariable String supplierCode) {
        return repo.findBySupplierCode(supplierCode);
    }
}
