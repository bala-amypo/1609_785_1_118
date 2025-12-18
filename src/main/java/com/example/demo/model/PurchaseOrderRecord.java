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
    @Column(unique=true,nullable=false)
    private String poNumber;
    private Long supplierId;
    private String itemDescription;
    @Min(1)
    private Integer quantity;
    private LocalDate promisedDeliveryDate;
    private LocalDate issuedDate;
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
     public void setPromisedDeliveryDate(LocalDate promisedDeliveryDate){
        this.promisedDeliveryDate=promisedDeliveryDate;
    }
    public void setIssuedDate(LocalDate issuedDate){
        this.issuedDate=issuedDate;
    }
    public Long getId(){
        return id;
    }
    public String getPoNumber(){
        return poNumber;
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
   
    public LocalDate getIssuedDate(){
        return issuedDate;
    }
    public PurchaseOrderRecord(Long id,String poNumber,Long supplierId,String itemDescription,Integer quantity,LocalDate promisedDeliveryDate,LocalDate issuedDate){
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