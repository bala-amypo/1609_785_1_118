package com.example.demo.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class DeliveryRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long pold;
    private LocalDate actualDeliveryDate;
    @Min(0)
    private Integer deliveredQuantity;
    private String notes;
    public void setId(Long id){
        this.id=id;
    }
    public void setPold(Long pold){
        this.pold=pold;
    }
     public void setActualDeliveryDate(LocalDate actualDeliveryDate){
        this.actualDeliveryDate=actualDeliveryDate;
    }
     public void setDeliveredQuantity(Integer deliveredQuantity){
        this.deliveredQuantity=deliveredQuantity;
    }
    public void setNotes(String notes){
        this.notes=notes;
    }
    public Long getId(){
        return id;
    }
    public Long getPold(){
        return pold;
    }
     public LocalDate getActualDeliveryDate(){
        return actualDeliveryDate;
    }
    public Integer getDeliveredQuantity(){
        return deliveredQuantity;
    }
   
    public String getNotes(){
        return notes;
    }
    public DeliveryRecord(Long id,Long pold,LocalDate actualDeliveryDate,Integer deliveredQuantity,String notes){
        this.id=id;
        this.pold=pold;
        this.actualDeliveryDate=actualDeliveryDate;
        this.deliveredQuantity=deliveredQuantity;
        this.notes=notes;
    }
    public DeliveryRecord(){

    }



}