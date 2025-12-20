package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;

public interface SupplierRiskAlertService {
    SupplierRiskAlert createAlert(SupplierRiskAlert alert);
    void resolveAlert(Long alertId);
    List<SupplierRiskAlert> getActiveAlertsBySupplier(Long supplierId);
}