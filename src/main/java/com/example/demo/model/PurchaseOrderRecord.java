package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PurchaseOrderRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String poNumber;

    private Long supplierId;
    private String itemDescription;
    private Integer quantity;
    private LocalDate promisedDeliveryDate;
    private LocalDate issuedDate;

    // ✅ Default constructor
    public PurchaseOrderRecord() {
    }

    // ✅ Parameterized constructor
    public PurchaseOrderRecord(
            String poNumber,
            Long supplierId,
            Integer quantity,
            LocalDate promisedDeliveryDate
    ) {
        this.poNumber = poNumber;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.promisedDeliveryDate = promisedDeliveryDate;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPromisedDeliveryDate() {
        return promisedDeliveryDate;
    }

    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) {
        this.promisedDeliveryDate = promisedDeliveryDate;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }
}
