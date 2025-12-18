package com.example.demo.service.impl;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRecordRepository;
import com.example.demo.service.DelayScoreService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DelayScoreServiceImpl implements DelayScoreService {

    private final DelayScoreRecordRepository repo;

    public DelayScoreServiceImpl(DelayScoreRecordRepository repo) {
        this.repo = repo;
    }

    public DelayScoreRecord computeDelayScore(Long poId) {
        DelayScoreRecord score = new DelayScoreRecord();
        score.setPoId(poId);
        score.setScore(0); 
        return repo.save(score);
    }

    public List<DelayScoreRecord> getScoresBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    public DelayScoreRecord getScoreById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<DelayScoreRecord> getAllScores() {
        return repo.findAll();
    }
}
