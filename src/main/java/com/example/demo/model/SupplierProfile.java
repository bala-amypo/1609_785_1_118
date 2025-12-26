package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier_profile")
public class SupplierProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String supplierCode;

    private String name;
    private Boolean active = true;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSupplierCode() { return supplierCode; }
    public void setSupplierCode(String supplierCode) { this.supplierCode = supplierCode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
