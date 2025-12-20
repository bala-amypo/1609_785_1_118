package com.example.demo.controller;

import com.example.demo.model.SupplierProfile;
import com.example.demo.service.SupplierProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "SupplierProfileController")
public class SupplierProfileController {
    @Autowired
    private SupplierProfileService service;

    @PostMapping
    public SupplierProfile create(@RequestBody SupplierProfile supplier) {
        return service.createSupplier(supplier);
    }

    @GetMapping("/{id}")
    public SupplierProfile getById(@PathVariable Long id) {
        return service.getSupplierById(id);
    }

    @GetMapping
    public List<SupplierProfile> getAll() {
        return service.getAllSuppliers();
    }
}