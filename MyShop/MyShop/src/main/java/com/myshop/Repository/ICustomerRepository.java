package com.myshop.Repository;

import com.myshop.Bean.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findByCustomerNameLike(Pageable pageable, String name);
}
