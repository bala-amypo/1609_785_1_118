package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
public class DelayScoreServiceImpl implements DelayScoreService {
    @Autowired private DelayScoreRecordRepository scoreRepo;
    @Autowired private PurchaseOrderRecordRepository poRepo;
    @Autowired private DeliveryRecordRepository delRepo;
    @Autowired private SupplierProfileRepository supplierRepo;
    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        // Requirement: Fetch PO and deliveries. Throw "No deliveries" if empty
        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new RuntimeException("PO not found"));
        
        List<DeliveryRecord> deliveries = delRepo.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new RuntimeException("No deliveries");
        }

        // Requirement: Check supplier active status. Throw "Inactive supplier" if false
        SupplierProfile supplier = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        
        if (!supplier.getActive()) {
            throw new RuntimeException("Inactive supplier");
        }

        // Requirement: Calculate delay between Promised and Actual delivery dates
        DeliveryRecord delivery = deliveries.get(0);
        long days = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), delivery.getActualDeliveryDate());
        int delayDays = (int) Math.max(0, days);

        // Requirement: Map delay to Score and Severity
        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays(delayDays);

        if (delayDays == 0) {
            record.setScore(100.0);
            record.setDelaySeverity("NONE");
        } else if (delayDays <= 7) {
            record.setScore(80.0);
            record.setDelaySeverity("MINOR");
        } else {
            record.setScore(40.0);
            record.setDelaySeverity("SEVERE");
        }

        return scoreRepo.save(record);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplierId(Long supplierId) {
        return scoreRepo.findBySupplierId(supplierId);
    }

    @Override
    public DelayScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id).orElseThrow();
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}