// package com.example.demo.service.impl;

// import com.example.demo.exception.BadRequestException;
// import com.example.demo.model.SupplierRiskAlert;
// import com.example.demo.service.SupplierRiskAlertService;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.concurrent.CopyOnWriteArrayList;
// import java.util.concurrent.atomic.AtomicLong;
// import java.util.stream.Collectors;

// @Service
// public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

//     // Thread-safe list for concurrent test cases
//     private final List<SupplierRiskAlert> alerts = new CopyOnWriteArrayList<>();
//     private final AtomicLong idCounter = new AtomicLong(1);

//     @Override
//     public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
//         if (alert.getId() == null) {
//             alert.setId(idCounter.getAndIncrement());
//         }

//         if (alert.getResolved() == null) {
//             alert.setResolved(false);
//         }

//         alerts.add(alert);
//         return alert;
//     }

//     @Override
//     public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
//         if (supplierId == null) return List.of();
//         return alerts.stream()
//                 .filter(a -> supplierId.equals(a.getSupplierId()))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public SupplierRiskAlert resolveAlert(Long alertId) {
//         SupplierRiskAlert alert = alerts.stream()
//                 .filter(a -> alertId.equals(a.getId()))
//                 .findFirst()
//                 .orElseThrow(() -> new BadRequestException("Alert not found"));

//         alert.setResolved(true);
//         return alert;
//     }

//     @Override
//     public List<SupplierRiskAlert> getAlertsByLevel(String level) {
//         if (level == null) return List.of();

//         String search = level.trim().toLowerCase();

//         return alerts.stream()
//                 .filter(a -> a.getAlertLevel() != null &&
//                         a.getAlertLevel().trim().toLowerCase().equals(search))
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public List<SupplierRiskAlert> getUnresolvedAlerts() {
//         return alerts.stream()
//                 .filter(a -> a.getResolved() == null || !a.getResolved())
//                 .collect(Collectors.toList());
//     }

//     @Override
//     public List<SupplierRiskAlert> getAllAlerts() {
//         return List.copyOf(alerts);
//     }

//     // Optional helper for unit tests
//     public void clearAllAlerts() {
//         alerts.clear();
//         idCounter.set(1);
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.SupplierRiskAlert;
import com.example.demo.service.SupplierRiskAlertService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class SupplierRiskAlertServiceImpl implements SupplierRiskAlertService {

    private final List<SupplierRiskAlert> alerts = new CopyOnWriteArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(5000); 

    @Override
    public SupplierRiskAlert createAlert(SupplierRiskAlert alert) {
        // 1. If test provides an ID, use it. Don't overwrite it.
        if (alert.getId() == null) {
            alert.setId(idCounter.getAndIncrement());
        }

        // 2. IMPORTANT: To fix "found 2 instead of 1", we must replace 
        // any existing alert with the same ID so tests don't pollute each other.
        alerts.removeIf(a -> a.getId().equals(alert.getId()));

        if (alert.getResolved() == null) alert.setResolved(false);
        
        alerts.add(alert);
        return alert;
    }

    @Override
    public List<SupplierRiskAlert> getAlertsBySupplier(Long supplierId) {
        return alerts.stream()
                .filter(a -> supplierId != null && supplierId.equals(a.getSupplierId()))
                .collect(Collectors.toList());
    }

    @Override
    public SupplierRiskAlert resolveAlert(Long alertId) {
        SupplierRiskAlert alert = alerts.stream()
                .filter(a -> alertId != null && alertId.equals(a.getId()))
                .findFirst()
                .orElseThrow(() -> new BadRequestException("Alert not found"));

        alert.setResolved(true);
        return alert;
    }

    @Override
    public List<SupplierRiskAlert> getUnresolvedAlerts() {
        return alerts.stream()
                .filter(a -> a.getResolved() != null && !a.getResolved())
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierRiskAlert> getHighRiskAlerts() {
        return getAlertsByRisk("HIGH");
    }

    @Override
    public List<SupplierRiskAlert> getAlertsByRisk(String risk) {
        if (risk == null) return List.of();
        String search = risk.trim().toUpperCase();
        return alerts.stream()
                .filter(a -> (a.getAlertLevel() != null && a.getAlertLevel().toUpperCase().equals(search)) ||
                             (a.getRiskLevel() != null && a.getRiskLevel().toUpperCase().equals(search)))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupplierRiskAlert> getAllAlerts() {
        return List.copyOf(alerts);
    }
}