package com.customermanagement.repository;

import com.customermanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends PagingAndSortingRepository<Customer,Integer> {
}
