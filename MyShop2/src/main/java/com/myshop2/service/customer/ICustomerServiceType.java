package com.myshop2.service.customer;

import com.myshop2.bean.Customer;
import com.myshop2.bean.CustomerType;

import java.util.Optional;

public interface ICustomerServiceType {
    Iterable<CustomerType> findAll();

    Optional<CustomerType> findById(Integer customerTypeId);
}
