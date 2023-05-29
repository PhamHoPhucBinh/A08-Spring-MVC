package com.myshopjava8.repository;


import com.myshopjava8.bean.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    Optional<Manufacturer> findByManufacturerNameLike(String manufacturerName);
    List<Manufacturer> findAll();
}
