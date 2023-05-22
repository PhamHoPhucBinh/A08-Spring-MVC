package com.myshop.Bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String customerId;
    @NotBlank
    private String customerName;

    @NotEmpty
    private String customerBirthday;
    private Integer customerGender;
    @NotBlank
    @Pattern(regexp = "^((091)|(090))[0-9]{7}$",message = "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx.")
    private String customerPhone;

    @NotBlank
    @Email
    private String customerEmail;

    @NotBlank
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customerTypeId",nullable = false,referencedColumnName = "customerTypeId")
    @JsonBackReference
    private CustomerType customerType;

}
