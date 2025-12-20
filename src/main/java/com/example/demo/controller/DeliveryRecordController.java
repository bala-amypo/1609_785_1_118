package com.example.demo.controller;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.service.DeliveryRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@Tag(name = "DeliveryRecordController")
public class DeliveryRecordController {
    @Autowired
    private DeliveryRecordService service;

    @PostMapping
    public DeliveryRecord add(@RequestBody DeliveryRecord delivery) {
        return service.addDelivery(delivery);
    }

    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getByPo(@PathVariable Long poId) {
        return service.getDeliveriesByPoId(poId);
    }
}