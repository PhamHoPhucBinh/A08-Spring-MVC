package com.myshop.Service;

import com.myshop.Bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> showAll(Pageable pageable);

    Page<Customer> findByName(Pageable pageable, String customerName);

    Iterable<Customer> findAll();

    Customer findById(String customerId);

    void save(Customer customer);

    void delete(Customer customer);
}
