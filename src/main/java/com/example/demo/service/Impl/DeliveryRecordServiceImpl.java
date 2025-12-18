package com.example.demo.service;

import com.example.demo.model.SupplierProfile;
import java.util.List;

public interface SupplierProfileService {
    SupplierProfile createSupplier(SupplierProfile supplier);
    SupplierProfile getSupplierById(Long id);
    SupplierProfile getBySupplierCode(String code);
    List<SupplierProfile> getAllSuppliers();
    SupplierProfile updateSupplierStatus(Long id, boolean active);
}

SupplierProfileServiceImpl.java

package com.example.demo.service.impl;

import com.example.demo.model.SupplierProfile;
import com.example.demo.repository.SupplierProfileRepository;
import com.example.demo.service.SupplierProfileService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierProfileServiceImpl implements SupplierProfileService {

    private final SupplierProfileRepository repo;

    public SupplierProfileServiceImpl(SupplierProfileRepository repo) {
        this.repo = repo;
    }

    public SupplierProfile createSupplier(SupplierProfile supplier) {
        return repo.save(supplier);
    }

    public SupplierProfile getSupplierById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public SupplierProfile getBySupplierCode(String code) {
        return repo.findBySupplierCode(code);
    }

    public List<SupplierProfile> getAllSuppliers() {
        return repo.findAll();
    }

    public SupplierProfile updateSupplierStatus(Long id, boolean active) {
        SupplierProfile s = getSupplierById(id);
        s.setActive(active);
        return repo.save(s);
    }
}


---

PurchaseOrderService.java

package com.example.demo.service;

import com.example.demo.model.PurchaseOrderRecord;
import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po);
    List<PurchaseOrderRecord> getPOsBySupplier(Long supplierId);
    PurchaseOrderRecord getPOById(Long id);
    List<PurchaseOrderRecord> getAllPurchaseOrders();
}

PurchaseOrderServiceImpl.java

package com.example.demo.service.impl;

import com.example.demo.model.PurchaseOrderRecord;
import com.example.demo.repository.PurchaseOrderRecordRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRecordRepository repo;

    public PurchaseOrderServiceImpl(PurchaseOrderRecordRepository repo) {
        this.repo = repo;
    }

    public PurchaseOrderRecord createPurchaseOrder(PurchaseOrderRecord po) {
        return repo.save(po);
    }

    public List<PurchaseOrderRecord> getPOsBySupplier(Long supplierId) {
        return repo.findBySupplierId(supplierId);
    }

    public PurchaseOrderRecord getPOById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<PurchaseOrderRecord> getAllPurchaseOrders() {
        return repo.findAll();
    }
}


---

DeliveryRecordService.java

package com.example.demo.service;

import com.example.demo.model.DeliveryRecord;
import java.util.List;

public interface DeliveryRecordService {
    DeliveryRecord recordDelivery(DeliveryRecord delivery);
    List<DeliveryRecord> getDeliveriesByPO(Long poId);
    DeliveryRecord getDeliveryById(Long id);
    List<DeliveryRecord> getAllDeliveries();
}

DeliveryRecordServiceImpl.java

package com.example.demo.service.impl;

import com.example.demo.model.DeliveryRecord;
import com.example.demo.repository.DeliveryRecordRepository;
import com.example.demo.service.DeliveryRecordService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository repo;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository repo) {
        this.repo = repo;
    }

    public DeliveryRecord recordDelivery(DeliveryRecord delivery) {
        return repo.save(delivery);
    }

    public List<DeliveryRecord> getDeliveriesByPO(Long poId) {
        return repo.findByPoId(poId);
    }

    public DeliveryRecord getDeliveryById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<DeliveryRecord> getAllDeliveries() {
        return repo.findAll();
    }
}


