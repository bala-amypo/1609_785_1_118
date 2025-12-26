package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.DelayScoreRecord;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository delayScoreRecordRepository;
    private final PurchaseOrderRecordRepository poRepository;
    private final SupplierProfileRepository supplierProfileRepository;
    private final DeliveryRecordRepository deliveryRepository;

    // ✅ Constructor injection
    public DelayScoreServiceImpl(
            DelayScoreRecordRepository delayScoreRecordRepository,
            PurchaseOrderRecordRepository poRepository,
            SupplierProfileRepository supplierProfileRepository,
            DeliveryRecordRepository deliveryRepository
    ) {
        this.delayScoreRecordRepository = delayScoreRecordRepository;
        this.poRepository = poRepository;
        this.supplierProfileRepository = supplierProfileRepository;
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public DelayScoreRecord computeDelayScore(Long poId) {
        Optional<PurchaseOrderRecord> poOpt = poRepository.findById(poId);
        if (poOpt.isEmpty()) {
            throw new BadRequestException("PO not found");
        }

        PurchaseOrderRecord po = poOpt.get();
        Optional<SupplierProfile> supplierOpt = supplierProfileRepository.findById(po.getSupplierId());
        if (supplierOpt.isEmpty() || !supplierOpt.get().getActive()) {
            throw new BadRequestException("Inactive supplier");
        }

        List<DeliveryRecord> deliveries = deliveryRepository.findByPoId(poId);
        if (deliveries.isEmpty()) {
            throw new BadRequestException("No deliveries found for PO");
        }

        DeliveryRecord delivery = deliveries.get(0);
        long delayDays = ChronoUnit.DAYS.between(po.getPromisedDeliveryDate(), delivery.getActualDeliveryDate());

        DelayScoreRecord record = new DelayScoreRecord();
        record.setPoId(poId);
        record.setSupplierId(po.getSupplierId());
        record.setDelayDays((int) delayDays);

        if (delayDays <= 0) {
            record.setDelaySeverity("ON_TIME");
            record.setScore(100.0);
        } else if (delayDays <= 3) {
            record.setDelaySeverity("MINOR");
            record.setScore(90.0);
        } else {
            record.setDelaySeverity("MAJOR");
            record.setScore(70.0);
        }

        return delayScoreRecordRepository.save(record);
    }

    @Override
    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return delayScoreRecordRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<DelayScoreRecord> getAllScores() {
        return delayScoreRecordRepository.findAll();
    }
}
