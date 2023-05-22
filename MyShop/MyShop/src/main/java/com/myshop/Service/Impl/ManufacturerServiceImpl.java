package com.myshop.Service.Impl;

import com.myshop.Bean.Manufacturer;
import com.myshop.Repository.IManufacturerRepository;
import com.myshop.Service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private IManufacturerRepository manufacturerRepository;
    @Override
    public Iterable<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
}
