package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayScoreController {

    @Autowired
    private DelayScoreService delayScoreService;

    @PostMapping("/compute/{poId}")
    public DelayScoreRecord compute(@PathVariable Long poId) {
        // FIX: Match the method name in DelayScoreService (computeDelayScore)
        return delayScoreService.computeDelayScore(poId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<DelayScoreRecord> listBySupplier(@PathVariable Long supplierId) {
        return delayScoreService.getScoresBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public DelayScoreRecord getById(@PathVariable Long id) {
        return delayScoreService.getScoreById(id);
    }

    @GetMapping("/")
    public List<DelayScoreRecord> listAll() {
        return delayScoreService.getAllScores();
    }
}