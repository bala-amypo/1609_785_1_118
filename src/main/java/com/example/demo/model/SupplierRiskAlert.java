package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private String alertLevel;
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved;

    public SupplierRiskAlert() {
        this.alertDate = LocalDateTime.now();
        this.resolved = false;
    }

    public SupplierRiskAlert(Long supplierId, String alertLevel, String message) {
        this();
        this.supplierId = supplierId;
        this.alertLevel = alertLevel;
        this.message = message;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
