package com.myshop2.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceId;

    @NotBlank
    private String invoiceDate;

    @NotEmpty
    private Double invoiceTotalMoney;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false, referencedColumnName = "customerId")
    private Customer customer;

    public Invoice() {
    }

    public Invoice(Integer invoiceId, String invoiceDate, Double invoiceTotalMoney, Customer customer) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.invoiceTotalMoney = invoiceTotalMoney;
        this.customer = customer;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getInvoiceTotalMoney() {
        return invoiceTotalMoney;
    }

    public void setInvoiceTotalMoney(Double invoiceTotalMoney) {
        this.invoiceTotalMoney = invoiceTotalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
