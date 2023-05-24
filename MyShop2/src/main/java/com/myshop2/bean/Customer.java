package com.myshop2.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotBlank
    private String customerName;

    @NotBlank
    private String customerPhone;

    @NotEmpty
    private String customerBirthday;

    @NotEmpty
    private Integer customerGender;

    @NotBlank
    @NotEmpty
    @Email
    private String customerEmail;

    @NotBlank
    private String customerAddress;
}
