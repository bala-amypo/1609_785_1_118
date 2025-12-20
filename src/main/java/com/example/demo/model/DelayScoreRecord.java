package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

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

    public DelayScoreRecord() {
        this.computedAt = LocalDateTime.now();
    }

    public DelayScoreRecord(Long supplierId, Long poId) {
        this.supplierId = supplierId;
        this.poId = poId;
        this.computedAt = LocalDateTime.now();
    }

    public void setDelayDays(Integer delayDays) { this.delayDays = delayDays; }
    public void setDelaySeverity(String delaySeverity) { this.delaySeverity = delaySeverity; }
    public void setScore(Double score) { this.score = score; }
}
