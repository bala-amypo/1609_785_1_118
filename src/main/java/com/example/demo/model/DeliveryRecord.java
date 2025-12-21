package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_records")
public class DeliveryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long poId;
    private LocalDateTime actualDeliveryDate;
    private String deliveryStatus;
    private String notes;

    public DeliveryRecord() {}

    // Getters and Setters
    public Long getId() {
     return id; 
     }
    public void setId(Long id) { 
    this.id = id;
     }
    public Long getPoId() { 
    return poId; 
    }
    public void setPoId(Long poId) { 
    this.poId = poId;
     }
    public LocalDateTime getActualDeliveryDate() { return actualDeliveryDate; }
    public void setActualDeliveryDate(LocalDateTime date) { this.actualDeliveryDate = date; }
    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String status) { this.deliveryStatus = status; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}