package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.repository.DelayScoreRecordRepository;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayScoreController{

    private final DelayScoreRecordRepository repo;

    public DelayScoreController(DelayScoreRecordRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/compute/{poId}")
    public DelayScoreRecord compute(@PathVariable Long poId) {
        DelayScoreRecord d = new DelayScoreRecord();
        d.setPoId(poId);
        d.setDelayDays(2);
        d.setDelaySeverity("MINOR");
        d.setScore(8.5);
        d.setComputedAt(LocalDateTime.now());
        return repo.save(d);
    }

    @GetMapping
    public List<DelayScoreRecord> getAll() {
        return repo.findAll();
    }
}
