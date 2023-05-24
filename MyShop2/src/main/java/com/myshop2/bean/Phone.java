package com.myshop2.bean;

import jakarta.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer phoneId;

    private String phoneName;

    private Double phonePrice;

    @ManyToOne
    @JoinColumn(name = "manufacturerId", nullable = false, referencedColumnName = "manufacturerId")
    private Manufacturer manufacturer;
    public Phone() {
    }

    public Phone(Integer phoneId, String phoneName, Double phonePrice, Manufacturer manufacturer) {
        this.phoneId = phoneId;
        this.phoneName = phoneName;
        this.phonePrice = phonePrice;
        this.manufacturer = manufacturer;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public Double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(Double phonePrice) {
        this.phonePrice = phonePrice;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
