package com.example.demo.controller;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.service.PurchaseOrderService;
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
@RequestMapping("/api/purchase-orders")
@Tag(name = "PurchaseOrderController")
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderService service;

    @PostMapping
    public PurchaseOrderRecord create(@RequestBody PurchaseOrderRecord po) {
        return service.createPO(po);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrderRecord> getBySupplier(@PathVariable Long supplierId) {
        return service.getPOsBySupplierId(supplierId);
    }
}