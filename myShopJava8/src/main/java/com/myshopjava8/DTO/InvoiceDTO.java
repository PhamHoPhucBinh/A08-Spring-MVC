package com.myshopjava8.DTO;

public class InvoiceDTO {
    String buyDate;
    Integer phoneId;
    Integer invoiceId;
    Integer customerId;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String buyDate, Integer phoneId, Integer invoiceId, Integer customerId) {
        this.buyDate = buyDate;
        this.phoneId = phoneId;
        this.invoiceId = invoiceId;
        this.customerId = customerId;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
