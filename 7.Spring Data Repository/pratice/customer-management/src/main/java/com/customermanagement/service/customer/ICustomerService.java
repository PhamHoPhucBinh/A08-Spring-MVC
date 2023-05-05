package com.customermanagement.service.customer;

import com.customermanagement.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);
}
