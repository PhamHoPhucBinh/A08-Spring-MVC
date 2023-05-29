package com.myshopjava8.service.customer;


import com.myshopjava8.bean.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Integer customerId);

    void save(Customer customer);

    void remove(Integer customerId);
}
