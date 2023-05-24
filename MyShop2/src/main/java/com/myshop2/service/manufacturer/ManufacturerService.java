package com.myshop2.service.manufacturer;

import com.myshop2.bean.Manufacturer;
import com.myshop2.repository.ManufacturerRepository;
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
