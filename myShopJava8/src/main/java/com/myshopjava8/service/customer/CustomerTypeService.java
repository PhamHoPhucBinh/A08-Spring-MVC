package com.myshopjava8.service.customer;


import com.myshopjava8.bean.CustomerType;
import com.myshopjava8.repository.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerTypeService implements ICustomerServiceType {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public Iterable<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Integer customerTypeId) {
        return customerTypeRepository.findById(customerTypeId);
    }
}
