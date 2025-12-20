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

    @Override
    public DelayScoreRecord computeAndSaveScore(Long poId) {
        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new RuntimeException("PO not found"));

        List<DeliveryRecord> deliveries = delRepo.findByPoId(poId);
        if (deliveries.isEmpty()) throw new RuntimeException("No delivery record");

        // FIX: Access the first object in the List
        DeliveryRecord delivery = deliveries.get(0);

        long daysBetween = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), delivery.getActualDeliveryDate());
        int delayDays = (int) Math.max(0, daysBetween);

        DelayScoreRecord ds = new DelayScoreRecord();
        ds.setPoId(poId);
        ds.setSupplierId(po.getSupplierId());
        ds.setDelayDays(delayDays);

        if (delayDays == 0) { ds.setDelaySeverity("ON_TIME"); ds.setScore(100.0); }
        else if (delayDays <= 3) { ds.setDelaySeverity("MINOR"); ds.setScore(80.0); }
        else { ds.setDelaySeverity("SEVERE"); ds.setScore(40.0); }

        return scoreRepo.save(ds);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplierId(Long id) {
        return scoreRepo.findBySupplierId(id);
    }
}