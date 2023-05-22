package com.myshop.Repository;

import com.myshop.Bean.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer,Integer> {
    List<Manufacturer> findByManufacturerName(String manufacturerName);
}
