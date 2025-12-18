package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRecordRepository repo;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repo) {
        this.repo = repo;
    }

    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        return repo.save(po);
    }

    public List<PurchaseOrderRecord> getPOsBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    public PurchaseOrderRecord getPOById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<PurchaseOrderRecord> getAllPurchaseOrders() {
        return repo.findAll();
    }
}

