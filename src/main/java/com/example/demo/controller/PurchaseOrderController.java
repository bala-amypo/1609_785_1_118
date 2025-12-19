package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<PurchaseOrderRecord> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getOrder(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public PurchaseOrderRecord create(@RequestBody PurchaseOrderRecord order) {
        return service.saveOrder(order);
    }
}
