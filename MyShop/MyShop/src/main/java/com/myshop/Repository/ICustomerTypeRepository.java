package com.myshop.Repository;

import com.myshop.Bean.Customer;
import com.myshop.Bean.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    List<Customer> findByCustomerTypeName(String customerTypeName);
}
