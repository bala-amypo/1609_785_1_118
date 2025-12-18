package com.example.demo.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class PurchaseOrderRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String pold;
    private LocalDate actualDeliveryDate;
    private Integer deliveredQuantity;
    private String note;
    public void setId(Long id){
        this.id=id;
    }
    public void setPold(String pold){
        this.pold=pold;
    }
    public void setSupplierId(Long supplierId){
        this.supplierId=supplierId;
    }
    public void setItemDescription(String itemDescription){
        this.itemDescription=itemDescription;
    }
     public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }
     public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate){
        this.promisedDeliveryDate=promisedDeliveryDate;
    }
    public void setIssuedDate(LocalDate issuedDate){
        this.issuedDate=issuedDate;
    }
    public Long getId(){
        return id;
    }
    public String getPold(){
        return pold;
    }
     public Long getSupplierId(){
        return supplierId;
    }

    public String getItemDescription(){
        return itemDescription;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public LocalDate getPromisedDeliveryDate(){
        return promisedDeliveryDate;
    }
   
    public String getNotes(){
        return notes;
    }
    public PurchaseOrderRecord(Long id,String pold,LocalDate actualDeliveryDate,Integer deliveredquantity,String notes){
        this.id=id;
        this.pold=poNumber;
        this.actualDeliveryDate=actualDeliveryDate;
        this.deliveredQuantity=deliveredquantity;
        this.notes=notes;
    }
    public PurchaseOrderRecord(){

    }



}