package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderRecord createPO(PurchaseOrderRecord po);
    List<PurchaseOrderRecord> getPOsBySupplierId(Long supplierId);
}