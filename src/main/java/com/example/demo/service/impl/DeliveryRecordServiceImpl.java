package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import com.example.demo.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordRepository deliveryRepo;

    @Autowired
    private PurchaseOrderRecordRepository poRepo;

    @Override
    public DeliveryRecord recordDelivery(DeliveryRecord delivery) {
        if (poRepo.findById(delivery.getPoId()).isEmpty())
            throw new BadRequestException("PO not found");
        if (delivery.getQuantityDelivered() < 0)
            throw new BadRequestException("Quantity must be >=0");
        return deliveryRepo.save(delivery);
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPO(Long poId) {
        return deliveryRepo.findByPoId(poId);
    }

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRepo.findAll();
    }
}
