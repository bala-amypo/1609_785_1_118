package com.example.demo.model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class SupplierProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String supplierCode;
    private String supplierName;
    private String email;
    private String phone;
    private Boolean active;
    private Date createdAt;
    public void setId(Long id){
        this.id=id;
    }
    public void setSupplierCode(String supplierCode){
        this.supplierCode=supplierCode;
    }
    public void setSupplierName(String supplierName){
        this.supplierName=supplierName;
    }
    public void setEmail(String email){
        this.email=email;
    }
     public void setPhone(String phone){
        this.phone=phone;
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
    public String getSupplierCode(){
        return supplierCode;
    }
     public String getSupplierName(){
        return supplierName;
    }

    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public Boolean getActive(){
        return active;
    }
   
    public Date getCreatedAt(){
        return createdAt;
    }
    public SupplierProfile(Long id,String supplierCode,String supplierName,String email,String phone,Boolean active,Date createdAt){
        this.id=id;
        this.supplierCode=supplierCode;
        this.supplierName=supplierName;
        this.email=email;
        this.phone=phone;
        this.active=active;
        this.createdAt=createdAt;
    }
    public SupplierProfile(){

    }



}