package com.myshopjava8.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manufacturer {
    @Id
    Integer manufacturerId;

    String manufacturerName;

    public Manufacturer() {
    }

    public Manufacturer(Integer manufacturerId, String manufacturerName) {
        this.manufacturerId = manufacturerId;
        this.manufacturerName = manufacturerName;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
