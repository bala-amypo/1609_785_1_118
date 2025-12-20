package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired private PurchaseOrderRecordRepository poRepo;
    @Autowired private SupplierProfileRepository supplierRepo;

    @Override
    public PurchaseOrderRecord createPO(PurchaseOrderRecord po) {
        SupplierProfile s = supplierRepo.findById(po.getSupplierId()).orElseThrow(() -> new RuntimeException("Supplier Not Found"));
        if (!Boolean.TRUE.equals(s.getActive())) throw new RuntimeException("Supplier must be active");
        return poRepo.save(po);
    }
    @Override public List<PurchaseOrderRecord> getPOsBySupplierId(Long id) { return poRepo.findBySupplierId(id); }
}