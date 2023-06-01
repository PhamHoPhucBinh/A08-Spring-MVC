package com.phonemanagement.repository;

import com.phonemanagement.bean.Smartphone;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends CrudRepository<Smartphone, Integer> {
}