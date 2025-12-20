package com.example.demo.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;

@Service
public class SupplierProfileImpl implements SupplierProfileService {

    private SupplierProfileRepository repository;

    public SupplierProfileImpl(SupplierProfileRepository repository) {
        this.repository = repository;
    }

    public SupplierProfile saveSupplier(SupplierProfile supplier) {
        supplier.setCreatedAt(LocalDateTime.now());
        return repository.save(supplier);
    }

    public SupplierProfile getSupplierById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<SupplierProfile> getAllSuppliers() {
        return repository.findAll();
    }

    public SupplierProfile updateSupplier(Long id, SupplierProfile supplier) {
        SupplierProfile existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setSupplierCode(supplier.getSupplierCode());
            existing.setName(supplier.getName());
            existing.setStatus(supplier.getStatus());
            return repository.save(existing);
        }
        return null;
    }

    public void deleteSupplier(Long id) {
        repository.deleteById(id);
    }
}
