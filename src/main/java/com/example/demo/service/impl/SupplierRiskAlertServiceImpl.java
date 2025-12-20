package com.example.demo.service.impl;

import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.repository.SupplierRiskAlertRepository;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {
    @Autowired private SupplierRiskAlertRepository repository;
    @Override public SupplierRiskAlert createAlert(SupplierRiskAlert a) { return repository.save(a); }
    @Override public void resolveAlert(Long id) {
        SupplierRiskAlert a = repository.findById(id).orElseThrow();
        a.setResolved(true);
        repository.save(a);
    }
    @Override public List<SupplierRiskAlert> getActiveAlertsBySupplier(Long id) { return repository.findBySupplierId(id); }
}