package com.myshopjava8.service.manufacturer;

import com.myshopjava8.bean.Manufacturer;
import com.myshopjava8.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManufacturerService implements IManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Iterable<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Integer manufacturerId) {
        return manufacturerRepository.findById(manufacturerId);
    }

    @Override
    public Optional<Manufacturer> findByName(String manufacturerName) {
        return manufacturerRepository.findByManufacturerNameLike(manufacturerName);
    }
}
