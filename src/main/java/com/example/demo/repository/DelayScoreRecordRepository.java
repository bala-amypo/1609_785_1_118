package com.example.demo.repository;

import com.example.demo.DelayScoreRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface DelayScoreRecordRepository extends JpaRepository<DelayScoreRecord, Long> {
    Optional<DelayScoreRecord> findByPoId(Long poId);
    List<DelayScoreRecord> findBySupplierId(Long supplierId);
}