package com.myshop.Bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invoiceDetailsId;

    @ManyToOne
    @JoinColumn(name = "phoneId", nullable = false, referencedColumnName = "phoneId")
    @JsonBackReference
    private Phone phone;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "invoiceId", nullable = false, referencedColumnName = "invoiceId")
    @JsonBackReference
    private Invoice invoice;

    public InvoiceDetails(Integer invoiceDetailsId, Integer quantity, Invoice invoice) {
        this.invoiceDetailsId = invoiceDetailsId;
        this.quantity = quantity;
        this.invoice = invoice;
    }

    public InvoiceDetails() {
    }

    public Integer getInvoiceDetailsId() {
        return invoiceDetailsId;
    }

    public void setInvoiceDetailsId(Integer invoiceDetailsId) {
        this.invoiceDetailsId = invoiceDetailsId;
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
