package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long poId;
    private Integer delayDays;
    private String delaySeverity;
    private Double score;
    private LocalDateTime computedAt;

    public DelayScoreRecord() {
    }

    public Long getId() {
        return id;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {     // ✅ FIXED
        this.poId = poId;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {  // ✅ FIXED
        this.delayDays = delayDays;
    }

    public String getDelaySeverity() {
        return delaySeverity;
    }

    public void setDelaySeverity(String delaySeverity) { // ✅ FIXED
        this.delaySeverity = delaySeverity;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {   // ✅ FIXED
        this.score = score;
    }

    public LocalDateTime getComputedAt() {
        return computedAt;
    }

    public void setComputedAt(LocalDateTime computedAt) { // ✅ FIXED
        this.computedAt = computedAt;
    }
}
