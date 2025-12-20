package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    @Autowired
    private DeliveryRecordRepository deliveryRepo;

    @Override
    public DeliveryRecord recordDelivery(DeliveryRecord delivery) {
        // Requirement: Logic to save the delivery record
        return deliveryRepo.save(delivery);
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByPO(Long poId) {
        // Requirement: Fetch deliveries associated with a specific PO
        return deliveryRepo.findByPoId(poId);
    }

    @Override
    public DeliveryRecord getDeliveryById(Long id) {
        return deliveryRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Delivery record not found"));
    }

    @Override
    public List<DeliveryRecord> getAllDeliveries() {
        return deliveryRepo.findAll();
    }
}