package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.DeliveryRecordRepository;
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
        PurchaseOrderRecord po = poRepo.findById(poId).orElseThrow(() -> new RuntimeException("PO not found"));
        List<DeliveryRecord> deliveries = delRepo.findByPoId(poId);
        if (deliveries.isEmpty()) throw new RuntimeException("No delivery recorded");

        long days = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), deliveries.get(0).getActualDeliveryDate());
        int delayDays = (int) Math.max(0, days);

        DelayScoreRecord ds = new DelayScoreRecord();
        ds.setPoId(poId);
        ds.setSupplierId(po.getSupplierId());
        ds.setDelayDays(delayDays);

        if (delayDays == 0) { ds.setDelaySeverity("ON_TIME"); ds.setScore(100.0); }
        else if (delayDays <= 3) { ds.setDelaySeverity("MINOR"); ds.setScore(80.0); }
        else if (delayDays <= 7) { ds.setDelaySeverity("MODERATE"); ds.setScore(50.0); }
        else { ds.setDelaySeverity("SEVERE"); ds.setScore(20.0); }

        return scoreRepo.save(ds);
    }
    @Override public List<DelayScoreRecord> getScoresBySupplierId(Long id) { return scoreRepo.findBySupplierId(id); }
}