package com.example.demo.model;
import java.util.Date;
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
    private Boolean active=true;
    private Date createdAt;
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
     public void setActive(Boolean active){
        this.active=active;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt=createdAt;
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
    public String getquantity(){
        return phone;
    }
    public Boolean getActive(){
        return active;
    }
   
    public Date getCreatedAt(){
        return createdAt;
    }
    public SupplierProfile(Long id,String poNumber,Long supplierId,String itemDescription,String phone,Boolean active,Date createdAt){
        this.id=id;
        this.poNumber=poNumber;
        this.supplierId=supplierId;
        this.itemDescription=itemDescription;
        this.phone=phone;
        this.active=active;
        this.createdAt=createdAt;
    }
    public SupplierProfile(){

    }



}