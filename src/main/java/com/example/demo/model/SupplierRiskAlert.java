package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SupplierRiskAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long supplierId;
    private String message;
    private Boolean resolved;

    public SupplierRiskAlert() {}

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean r) { this.resolved = r; }
    public void setSupplierId(Long id) { this.supplierId = id; }
    public void setMessage(String m) { this.message = m; }
}