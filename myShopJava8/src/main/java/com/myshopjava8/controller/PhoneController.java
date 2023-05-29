package com.myshopjava8.controller;


import com.myshopjava8.bean.Manufacturer;
import com.myshopjava8.bean.Phone;
import com.myshopjava8.service.manufacturer.IManufacturerService;
import com.myshopjava8.service.phone.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
//@RequestMapping
public class PhoneController {
    @Autowired
    private IPhoneService phoneService;

    @Autowired
    private IManufacturerService manufacturerService;

    // TODO: 24-May-23 list
    @GetMapping("/phones")
    public ModelAndView listPhone() {
        Iterable<Phone> phones = phoneService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/phone/list");
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

    // TODO: 24-May-23 : create
    @GetMapping("/Create-Phone")
    public ModelAndView showCreateForm() {
        Iterable<Manufacturer> manufacturers = manufacturerService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/phone/create");
        modelAndView.addObject("phone", new Phone());
        modelAndView.addObject("manufacturers", manufacturers);
        return modelAndView;
    }

    @PostMapping("/Create-Phone")
    public ModelAndView savePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("view/phone/create");
        modelAndView.addObject("phone", new Phone());
        modelAndView.addObject("message", "create successfully");
        return new ModelAndView("redirect:/phones");
    }

    // TODO: 24-May-23 : edit
    @GetMapping("/Edit-Phone/{phoneId}")
    public ModelAndView showEditForm(@PathVariable Integer phoneId) {
        Optional<Phone> phone = phoneService.findById(phoneId);
        if (phone.isPresent()) {
            Iterable<Manufacturer> manufacturers = manufacturerService.findAll();
            ModelAndView modelAndView = new ModelAndView("view/phone/edit");
            modelAndView.addObject("manufacturers", manufacturers);
            modelAndView.addObject("phone", phone.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/Edit-Phone")
    public ModelAndView updatePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("view/phone/edit");
        modelAndView.addObject("phone", phone);
        modelAndView.addObject("message", "Phone updated successfully");
        return modelAndView;
    }

    // TODO: 24-May-23 Delete
    @GetMapping("/Delete-Phone/{phoneId}")
    public ModelAndView showDeleteForm(@PathVariable Integer phoneId) {
        Optional<Phone> phone = phoneService.findById(phoneId);
        if (phone.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/phone/delete");
            modelAndView.addObject("phone", phone.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/Delete-Phone")
    public String deletePhone(@ModelAttribute("phone") Phone phone) {
        phoneService.remove(phone.getPhoneId());
        return "redirect:/phones";
    }
}
