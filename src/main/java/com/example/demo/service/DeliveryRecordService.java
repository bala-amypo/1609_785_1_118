package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {
    DeliveryRecord addDelivery(DeliveryRecord delivery);
    List<DeliveryRecord> getDeliveriesByPoId(Long poId);
}