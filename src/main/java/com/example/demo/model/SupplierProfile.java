package com.example.demo.entity;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class StudentEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String supplierCode;
    private String supllierName;
    private String email;
    private String phone;
    private Boolean active;
    private Date createdAt;
    public void setId(Integer id){
        this.id=id;
    }
    public void setsupplierCode(String supplierCode){
        this.username=username;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
     public void setPassword(String password){
        this.password=password;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt=createdAt;
    }
    public Integer getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
   
    public Date getCreatedAt(){
        return createdAt;
    }
    public StudentEntity(Integer id,String username,String email,String password,Date createdAt){
        this.username=username;
        this.email=email;
        this.password=password;
        this.createdAt=createdAt;
    }
    public StudentEntity(){

    }



}