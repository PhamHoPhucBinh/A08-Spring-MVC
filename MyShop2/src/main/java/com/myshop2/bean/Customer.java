package com.myshop2.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotEmpty(message = "name is required")
    private String customerName;

    @NotEmpty(message = "required")
    @Pattern(regexp = "^(84|0[3|5|7|8|9])+([0-9]{8})\\b$")
    private String customerPhone;

    @ManyToOne
    @JoinColumn(name = "customerTypeId", nullable = false, referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @NotEmpty
    private String customerBirthday;

    @NotEmpty
    private String customerGender;

    @NotBlank
    @NotEmpty(message = "email is required")
    @Email
    private String customerEmail;

    @NotBlank
    @NotEmpty(message = "address is required")
    private String customerAddress;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, String customerPhone, CustomerType customerType, String customerBirthday, String customerGender, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerType = customerType;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
