package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordRepository deliveryRepo;

    @PostMapping("/ rd")
    public DeliveryRecord recordDelivery(@RequestBody DeliveryRecord delivery) {
        return deliveryRepo.save(delivery);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getDeliveriesForPO(@PathVariable Long poId) {
        return deliveryRepo.findByPoId(poId);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getDelivery(@PathVariable Long id) {
        return deliveryRepo.findById(id).orElseThrow();
    }

    @GetMapping("/")
    public List<DeliveryRecord> listAll() {
        return deliveryRepo.findAll();
    }
}