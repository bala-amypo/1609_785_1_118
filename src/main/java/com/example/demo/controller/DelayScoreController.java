package com.example.demo.controller;

import com.example.demo.model.DelayScoreRecord;
import com.example.demo.service.DelayScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delay-scores")
public class DelayScoreController {

    @Autowired
    private DelayScoreService delayScoreService;

    @PostMapping("/compute/{poId}")
    public ResponseEntity<DelayScoreRecord> computeScore(@PathVariable Long poId) {
        return ResponseEntity.ok(delayScoreService.computeDelayScore(poId));
    }

    @GetMapping
    public ResponseEntity<List<DelayScoreRecord>> getAllScores() {
        return ResponseEntity.ok(delayScoreService.getAllScores());
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<DelayScoreRecord>> getScoresBySupplier(@PathVariable Long supplierId) {
        return ResponseEntity.ok(delayScoreService.getScoresBySupplier(supplierId));
    }
}
