package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long supplierId;
    private Long poId;
    private Integer delayDays;
    private String delaySeverity;
    private Double score;
    private LocalDateTime computedAt;

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

    public void setComputedAt(LocalDateTime computedAt) {
        this.computedAt = computedAt;
    }

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

    public LocalDateTime getComputedAt() {
        return computedAt;
    }

    public DelayScoreRecord() {
    }
}
