package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;
    private LocalDate actualDeliveryDate;
    private Integer deliveredQuantity;
    private String notes;

    public DeliveryRecord() {}

    public DeliveryRecord(Long poId, LocalDate actualDeliveryDate,
                          Integer deliveredQuantity) {
        this.poId = poId;
        this.actualDeliveryDate = actualDeliveryDate;
        this.deliveredQuantity = deliveredQuantity;
    }

    public Long getPoId() { return poId; }
    public LocalDate getActualDeliveryDate() { return actualDeliveryDate; }
}
