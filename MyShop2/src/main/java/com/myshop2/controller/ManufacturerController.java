package com.myshop2.controller;

import com.myshop2.bean.Manufacturer;
import com.myshop2.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
