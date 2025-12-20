package com.example.demo.service;

import com.example.demo.model.DelayScoreRecord;
import java.util.List;

public interface DelayScoreService {
    DelayScoreRecord computeDelayScore(Long poId);
    List<DelayScoreRecord> getScoresBySupplierId(Long supplierId);
    DelayScoreRecord getScoreById(Long id);
    List<DelayScoreRecord> getAllScores();
}