package com.myshopjava8.service.manufacturer;


import com.myshopjava8.bean.Manufacturer;

import java.util.Optional;

public interface IManufacturerService {
    Iterable<Manufacturer> findAll();

    Optional<Manufacturer> findById(Integer manufacturerId);

    Optional<Manufacturer> findByName(String manufacturerName);
}
