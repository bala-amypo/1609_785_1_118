package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class PurchaseOrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String poNumber;
    private Long supplierId;
    private LocalDate promisedDeliveryDate;

    public PurchaseOrderRecord() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }
    public LocalDate getPromisedDeliveryDate() { return promisedDeliveryDate; }
    public void setPromisedDeliveryDate(LocalDate date) { this.promisedDeliveryDate = date; }
}