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
    private String supllierName;
    private String email;
    private String phone;
    private Boolean active;
    private Date createdAt;
    public void setId(Long id){
        this.id=id;
    }
    public void setSupplierCode(String supplierCode){
        this.username=username;
    }
    public void setSupllierName(String supllierName){
        this.supllierName=supllierName;
    }
    public void setEmail(String email){
        this.email=email;
    }
     public void setPhone(String phone){
        this.phone=phone;
    }
     public void setActive(String active){
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
        return suppliername;
    }

    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getActive(){
        return active;
    }
   
    public Date getCreatedAt(){
        return createdAt;
    }
    public SupplierProfile(Integer id,String supplierCode,String supplierName,String email,String phone,string active,Date createdAt){
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