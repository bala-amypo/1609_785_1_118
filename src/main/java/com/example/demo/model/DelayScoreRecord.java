package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delay_score_records")
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private Long poId;
    private Integer delayDays;
    private String delaySeverity;
    private Double score;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    // Default constructor
    public DelayScoreRecord() {
    }

    // Auto set createdAt before insert
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ✅ Getters
    public Long getId() {
        return id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public Long getPoId() {
        return poId;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public String getDelaySeverity() {
        return delaySeverity;
    }

    public Double getScore() {
        return score;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ✅ Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public void setDelaySeverity(String delaySeverity) {
        this.delaySeverity = delaySeverity;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
