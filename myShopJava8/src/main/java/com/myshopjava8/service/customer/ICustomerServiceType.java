package com.myshopjava8.service.customer;


import com.myshopjava8.bean.CustomerType;

import java.util.Optional;

public interface ICustomerServiceType {
    Iterable<CustomerType> findAll();

    Optional<CustomerType> findById(Integer customerTypeId);
}
