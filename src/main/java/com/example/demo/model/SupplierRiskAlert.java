package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class SupplierRiskAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean resolved;

    public SupplierRiskAlert() {}

    public Boolean getResolved() { return resolved; }
    public void setResolved(Boolean resolved) { this.resolved = resolved; }
}