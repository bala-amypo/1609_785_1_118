package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierProfileServiceImpl
        implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository repo;

    public SupplierProfile createSupplier(SupplierProfile s) {
        return repo.save(s);
    }

    public SupplierProfile getSupplierById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public SupplierProfile getBySupplierCode(String code) {
        return repo.findBySupplierCode(code).orElseThrow();
    }

    public List<SupplierProfile> getAllSuppliers() {
        return repo.findAll();
    }

    public SupplierProfile updateSupplierStatus(Long id, boolean active) {
        SupplierProfile s = getSupplierById(id);
        s.setActive(active);
        return repo.save(s);
    }
}
