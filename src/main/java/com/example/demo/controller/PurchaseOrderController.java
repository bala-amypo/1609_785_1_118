package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    @GetMapping
    public List<PurchaseOrderRecord> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getOrdersBySupplier(@PathVariable Long supplierId) {
        return service.getOrdersBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public PurchaseOrderRecord getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public PurchaseOrderRecord createOrder(@RequestBody PurchaseOrderRecord order) {
        return service.saveOrder(order);
    }
}
