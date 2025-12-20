package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public DelayScoreRecord() {}

    public void setSupplierId(Long id) { this.supplierId = id; }
    public void setPoId(Long id) { this.poId = id; }
    public void setDelayDays(Integer d) { this.delayDays = d; }
    public void setDelaySeverity(String s) { this.delaySeverity = s; }
    public void setScore(Double s) { this.score = s; }
}