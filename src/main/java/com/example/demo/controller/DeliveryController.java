package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryRecordService service;

    public DeliveryController(DeliveryRecordService service) {
        this.service = service;
    }

    @GetMapping
    public List<DeliveryRecord> getAllDeliveries() {
        return service.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public DeliveryRecord getById(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @PostMapping
    public DeliveryRecord create(@RequestBody DeliveryRecord delivery) {
        return service.recordDelivery(delivery);
    }
}
