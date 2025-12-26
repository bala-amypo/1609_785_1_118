package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;
import com.example.demo.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.temporal.ChronoUnit;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    @Autowired
    private DelayScoreRecordRepository delayRepo;

    @Autowired
    private PurchaseOrderRecordRepository poRepo;

    @Autowired
    private DeliveryRecordRepository deliveryRepo;

    @Autowired
    private SupplierProfileRepository supplierRepo;

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        PurchaseOrderRecord po = poRepo.findById(poId)
                .orElseThrow(() -> new BadRequestException("PO not found"));
        SupplierProfile supplier = supplierRepo.findById(po.getSupplierId())
                .orElseThrow(() -> new BadRequestException("Supplier not found"));
        if (!supplier.getActive()) throw new BadRequestException("Supplier inactive");

        List<DeliveryRecord> deliveries = deliveryRepo.findByPoId(poId);
        if (deliveries.isEmpty()) throw new BadRequestException("No deliveries found");

        DeliveryRecord delivery = deliveries.get(0);
        long delay = ChronoUnit.DAYS.between(po.getPromisedDate(), delivery.getDeliveryDate());

        DelayScoreRecord score = new DelayScoreRecord();
        score.setPoId(poId);
        score.setSupplierId(po.getSupplierId());
        score.setDelayDays((int) delay);

        if (delay <= 0) {
            score.setDelaySeverity("ON_TIME");
            score.setScore(100.0);
        } else if (delay <= 3) {
            score.setDelaySeverity("MINOR");
            score.setScore(90.0);
        } else {
            score.setDelaySeverity("MAJOR");
            score.setScore(70.0);
        }

        return delayRepo.save(score);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayRepo.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayRepo.findAll();
    }
}
