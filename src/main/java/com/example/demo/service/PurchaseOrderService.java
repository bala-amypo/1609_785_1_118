package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService{
    List<PurchaseOrderRecord> getAllOrders();
    PurchaseOrderRecord getOrderById(Long id);
    PurchaseOrderRecord saveOrder(PurchaseOrderRecord order);
}
