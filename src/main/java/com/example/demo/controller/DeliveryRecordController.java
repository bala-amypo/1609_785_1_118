package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService service;

    @GetMapping
    public List<DeliveryRecord> getAllDeliveries() {
        return service.getAllDeliveries();
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getDeliveriesByPoId(@PathVariable Long poId) {
        return service.getDeliveriesByPoId(poId);
    }

    @GetMapping("/{id}")
    public DeliveryRecord getDeliveryById(@PathVariable Long id) {
        return service.getDeliveryById(id);
    }

    @PostMapping
    public DeliveryRecord createDelivery(@RequestBody DeliveryRecord delivery) {
        return service.saveDelivery(delivery);
    }
}
