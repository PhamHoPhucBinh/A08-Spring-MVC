package com.myshop2.controller;

import com.myshop2.bean.Manufacturer;
import com.myshop2.bean.Phone;
import com.myshop2.service.manufacturer.IManufacturerService;
import com.myshop2.service.phone.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
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
    public ModelAndView saveBook(@ModelAttribute("book") Phone phone) {
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
            ModelAndView modelAndView = new ModelAndView("view/phone/edit");
            modelAndView.addObject("phone", phone.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/Edit-Phone")
    public ModelAndView updateBook(@ModelAttribute("phone") Phone phone) {
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
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/Delete-Phone")
    public String deleteBook(@ModelAttribute("phone") Phone phone) {
        phoneService.remove(phone.getPhoneId());
        return "redirect:books";
    }
}
