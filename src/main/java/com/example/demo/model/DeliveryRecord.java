package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_record")
public class DeliveryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;
    private Integer quantityDelivered;
    private LocalDate deliveryDate;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPoId() { return poId; }
    public void setPoId(Long poId) { this.poId = poId; }
    public Integer getQuantityDelivered() { return quantityDelivered; }
    public void setQuantityDelivered(Integer quantityDelivered) { this.quantityDelivered = quantityDelivered; }
    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
}
