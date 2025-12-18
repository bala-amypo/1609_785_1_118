package com.example.demo.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.Min;

@Entity
public class PurchaseOrderRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String poNumber;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierProfile supplier;

    private String itemDescription;

    @Min(1)
    private Integer quantity;

    private LocalDate promisedDeliveryDate;
    private LocalDate issuedDate;

    public PurchaseOrderRecord() {}

    public PurchaseOrderRecord(Long id, String poNumber, SupplierProfile supplier, String itemDescription, Integer quantity, LocalDate promisedDeliveryDate, LocalDate issuedDate) {
        this.id = id;
        this.poNumber = poNumber;
        this.supplier = supplier;
        this.itemDescription = itemDescription;
        this.quantity = quantity;
        this.promisedDeliveryDate = promisedDeliveryDate;
        this.issuedDate = issuedDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }

    public SupplierProfile getSupplier() { return supplier; }
    public void setSupplier(SupplierProfile supplier) { this.supplier = supplier; }

    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDate getPromisedDeliveryDate() { return promisedDeliveryDate; }
    public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate) { this.promisedDeliveryDate = promisedDeliveryDate; }

    public LocalDate getIssuedDate() { return issuedDate; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }
}
