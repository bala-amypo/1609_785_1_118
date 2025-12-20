package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {
    @Autowired private DeliveryRecordRepository repository;
    @Override public DeliveryRecord addDelivery(DeliveryRecord d) { return repository.save(d); }
    @Override public List<DeliveryRecord> getDeliveriesByPoId(Long id) { return repository.findByPoId(id); }
}