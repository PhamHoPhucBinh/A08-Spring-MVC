package com.myshopjava8.controller;


import com.myshopjava8.bean.Manufacturer;
import com.myshopjava8.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
//@RequestMapping
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @ModelAttribute("manufacturers")
    public List<Manufacturer> getManufacturerName() {
        return manufacturerRepository.findAll();
    }
}
