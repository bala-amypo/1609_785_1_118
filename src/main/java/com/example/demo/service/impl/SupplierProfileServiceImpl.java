package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import com.example.demo.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    @Autowired
    private SupplierProfileRepository supplierRepo;

    @Override
    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public SupplierProfile getSupplierById(Long id) {
        return supplierRepo.findById(id).orElseThrow(() -> new BadRequestException("Supplier not found"));
    }

    @Override
    public Optional<SupplierProfile> getBySupplierCode(String code) {
        return supplierRepo.findBySupplierCode(code);
    }

    @Override
    public List<SupplierProfile> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public SupplierProfile updateSupplierStatus(Long id, boolean active) {
        SupplierProfile supplier = getSupplierById(id);
        supplier.setActive(active);
        return supplierRepo.save(supplier);
    }
}
