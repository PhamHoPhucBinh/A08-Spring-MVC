package com.myshop2.service.manufacturer;

import com.myshop2.bean.Manufacturer;

import java.util.Optional;

public interface IManufacturerService {
    Iterable<Manufacturer> findAll();

    Optional<Manufacturer> findById(Integer manufacturerId);

    Optional<Manufacturer> findByName(String manufacturerName);
}
