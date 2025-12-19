package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class SupplierRiskAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private String alertLevel;   // LOW / MEDIUM / HIGH
    private String message;
    private LocalDateTime alertDate;
    private Boolean resolved;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAlertDate(LocalDateTime alertDate) {
        this.alertDate = alertDate;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }

    public Long getId() {
        return id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getAlertDate() {
        return alertDate;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public SupplierRiskAlert(Long id, Long supplierId, String alertLevel,
                             String message, LocalDateTime alertDate, Boolean resolved) {
        this.id = id;
        this.supplierId = supplierId;
        this.alertLevel = alertLevel;
        this.message = message;
        this.alertDate = alertDate;
        this.resolved = resolved;
    }

    public SupplierRiskAlert() {

    }
}
