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

    public List<PurchaseOrderRecord> getAllOrders() {
        return repo.findAll();
    }

    public PurchaseOrderRecord getOrderById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public PurchaseOrderRecord saveOrder(PurchaseOrderRecord order) {
        return repo.save(order);
    }
}
