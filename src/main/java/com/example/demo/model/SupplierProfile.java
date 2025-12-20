package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SupplierProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String supplierCode;
    private String supplierName;
    private Boolean active;
    private LocalDateTime createdAt = LocalDateTime.now();

    public SupplierProfile() {}

    public Long getId() { 
        return id; 
        }
    public void setId(Long id) { 
        this.id = id; 
        }
    public String getSupplierCode() { 
        return supplierCode; 
        }
    public void setSupplierCode(String code) { 
        this.supplierCode = code; 
        }
    public String getSupplierName() { 
        return supplierName; 
        }
    public void setSupplierName(String name) { 
        this.supplierName = name; 
        }
    public Boolean getActive() { 
        return active; 
        }
    public void setActive(Boolean active) { 
        this.active = active; 
        }
}