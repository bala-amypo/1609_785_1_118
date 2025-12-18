package com.example.demo.model;
import java.util.Date;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class SupplierProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String poNumber;
    private Long supplierId;
    private String itemDescription;
    private Integer quantity;
    private LocalDateTime promisedDeliveryDateDate
    private LocalDateTime issuedDate;
    public void setId(Long id){
        this.id=id;
    }
    public void setPoNumber(String poNumber){
        this.poNumber=poNumber;
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
     public void setProsmisedDeliveryDate(LocalDateTime promisedDeliveryDate){
        this.promisedDeliveryDate=promisedDeliveryDate;
    }
    public void setIssuedDate(LocalDateTime issuedDate){
        this.issuedDate=issuedDate;
    }
    public Long getId(){
        return id;
    }
    public String getPoNumber(){
        return poNumber;
    }
     public String getSupplierId(){
        return supplierId;
    }

    public String getItemDescription(){
        return itemDescription;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public LocalDateTime getPromisedDeliveryDate(){
        return promisedDeliveryDate;
    }
   
    public LocalDateTime getIssuedDate(){
        return issuedDate;
    }
    public SupplierProfile(Long id,String poNumber,Long supplierId,String itemDescription,Integer quantity,LocalDateTime promisedDeliveryDate,LocalDateTime issuedDate){
        this.id=id;
        this.poNumber=poNumber;
        this.supplierId=supplierId;
        this.itemDescription=itemDescription;
        this.quantity=quantity;
        this.promisedDeliveryDate=promisedDeliveryDate;
        this.issuedDate=issuedDate;
    }
    public PurchaseOrderRecord(){

    }



}