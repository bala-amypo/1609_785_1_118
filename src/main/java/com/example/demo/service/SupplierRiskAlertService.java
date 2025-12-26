package com.example.demo.service;

import com.example.demo.model.SupplierRiskAlert;
import java.util.List;

public interface SupplierRiskAlertService {

    SupplierRiskAlert createAlert(SupplierRiskAlert alert);

    List<SupplierRiskAlert> getAllAlerts();

    List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId);

    SupplierRiskAlert resolveAlert(Long id);
}
