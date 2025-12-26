package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryRecordController {

    @Autowired
    private DeliveryRecordService deliveryService;

    @PostMapping
    public ResponseEntity<DeliveryRecord> recordDelivery(@RequestBody DeliveryRecord delivery) {
        return ResponseEntity.ok(deliveryService.recordDelivery(delivery));
    }

    @GetMapping
    public ResponseEntity<List<DeliveryRecord>> getAllDeliveries() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }

    @GetMapping("/po/{poId}")
    public ResponseEntity<List<DeliveryRecord>> getDeliveriesByPO(@PathVariable Long poId) {
        return ResponseEntity.ok(deliveryService.getDeliveriesByPO(poId));
    }
}
