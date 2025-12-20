package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayScoreController {

    @Autowired
    private DelayScoreService delayScoreService;

    @PostMapping("/compute/{poId}")
    public DelayScoreRecord computeScore(@PathVariable Long poId) {
        return delayScoreService.computeAndSaveScore(poId);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<DelayScoreRecord> listScores(@PathVariable Long supplierId) {
        return delayScoreService.getScoresBySupplierId(supplierId);
    }

    @GetMapping("/{id}")
    public DelayScoreRecord getScore(@PathVariable Long id) {
        return delayScoreService.getScoreById(id);
    }

    @GetMapping("/")
    public List<DelayScoreRecord> listAll() {
        return delayScoreService.getAllScores();
    }
}