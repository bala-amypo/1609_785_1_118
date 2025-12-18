package com.example.demo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
@RestController
@RequestMapping("/api/deliveries")
public class DeliveryRecordController {

    private DeliveryRecordRepository repo;

    public DeliveryRecordController(DeliveryRecordRepository repo) {
        this.repo = repo;
    }
    @PostMapping
    public DeliveryRecord record(@RequestBody DeliveryRecord delivery) {
        return repo.save(delivery);
    }
    @GetMapping("/po/{poId}")
    public List<DeliveryRecord> getByPo(@PathVariable Long poId) {
        return repo.findByPoId(poId);
    }
    @GetMapping("/{id}")
    public DeliveryRecord getOne(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
    @GetMapping
    public List<DeliveryRecord> getAll() {
        return repo.findAll();
    }
}
