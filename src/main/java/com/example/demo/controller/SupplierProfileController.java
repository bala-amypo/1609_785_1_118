package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierProfileController {

    private final SupplierProfileRepository repo;

    public SupplierProfileController(SupplierProfileRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public SupplierProfile create(@RequestBody SupplierProfile supplier) {
        return repo.save(supplier);
    }

    @GetMapping
    public List<SupplierProfile> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}/status")
    public SupplierProfile updateStatus(@PathVariable Long id,
                                        @RequestParam Boolean active) {
        SupplierProfile s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setActive(active);
            repo.save(s);
        }
        return s;
    }
}
