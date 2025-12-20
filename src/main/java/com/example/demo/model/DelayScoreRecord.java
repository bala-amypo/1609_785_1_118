package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "delay_score_records")
public class DelayScoreRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long supplierId;

    @Column(nullable = false)
    private Long poId;

    private Integer delayDays;
    
    private String delaySeverity; // "NONE", "MINOR", "SEVERE"
    
    private Double score;

    @Column(length = 1000)
    private String notes; // Logic Requirement: Captures the reason/context for the score

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // Requirement: Audit timestamp

    public DelayScoreRecord() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSupplierId() { return supplierId; }
    public void setSupplierId(Long supplierId) { this.supplierId = supplierId; }

    public Long getPoId() { return poId; }
    public void setPoId(Long poId) { this.poId = poId; }

    public Integer getDelayDays() { return delayDays; }
    public void setDelayDays(Integer delayDays) { this.delayDays = delayDays; }

    public String getDelaySeverity() { return delaySeverity; }
    public void setDelaySeverity(String s) { this.delaySeverity = s; }

    public Double getScore() { return score; }
    public void setScore(Double s) { this.score = s; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}