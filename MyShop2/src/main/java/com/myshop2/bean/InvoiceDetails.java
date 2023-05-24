package com.myshop2.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceDetailsId;

    @ManyToOne
    @JoinColumn(name = "phoneId", nullable = false, referencedColumnName = "phoneId")
//    @JsonBackReference
    private Phone phone;

    @NotEmpty
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "invoiceId", nullable = false, referencedColumnName = "invoiceId")
//    @JsonBackReference
    private Invoice invoice;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Integer invoiceDetailsId, Phone phone, Integer quantity, Invoice invoice) {
        this.invoiceDetailsId = invoiceDetailsId;
        this.phone = phone;
        this.quantity = quantity;
        this.invoice = invoice;
    }

    public Integer getInvoiceDetailsId() {
        return invoiceDetailsId;
    }

    public void setInvoiceDetailsId(Integer invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
