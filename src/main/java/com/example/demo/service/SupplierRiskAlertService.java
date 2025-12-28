package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;

public interface SupplierRiskAlertService {
    SupplierRiskAlert createAlert(SupplierRiskAlert alert);
    List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId);
    SupplierRiskAlert resolveAlert(Long alertId);
    
    // Methods required by the failing tests
    List<SupplierRiskAlert> getUnresolvedAlerts();
    List<SupplierRiskAlert> getHighRiskAlerts();         // Required for testCriterialikeHighRiskSuppliers
    List<SupplierRiskAlert> getAlertsByRisk(String risk); // Required for testCriteriaAlertMediumRisk
    
    List<SupplierRiskAlert> getAllAlerts();
}