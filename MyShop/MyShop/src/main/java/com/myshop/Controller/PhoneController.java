package com.myshop.Controller;

import com.myshop.Bean.Phone;
import com.myshop.Service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping
public class PhoneController {

    @Autowired
    public PhoneService phoneService;


    @GetMapping("/phones")
    public ModelAndView listPhone(@PageableDefault(value = 5) Pageable pageable) {
        Page<Phone> phones = phoneService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("view/phone/list");
        if (phones.getContent().size() == 0) {
            modelAndView.addObject("msg", "No Phone exist.");
        }
        modelAndView.addObject("phones", phones);
        return modelAndView;
    }

//    @GetMapping("/create-phone")
//    public ModelAndView showPhoneCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("view/phone/create");
//        modelAndView.addObject("phone", new Phone());
//        return modelAndView;
//    }
//
//    @PostMapping("/create-phone")
//    public ModelAndView savePhone(@ModelAttribute("phone") Phone phone) {
//        phoneService.save(phone);
//        ModelAndView modelAndView = new ModelAndView("view/phone/create");
//        modelAndView.addObject("phone", new Phone());
//        modelAndView.addObject("message", "create successfully");
//        return new ModelAndView("redirect:/phones");
//    }
//
//    @GetMapping(value = "/update-phone/{phoneId}")
//    public ModelAndView showPhoneEditForm(@PathVariable Integer phoneId) {
//        Phone phone = phoneService.findById(phoneId);
//        return new ModelAndView("view/phone/update", "phone", phone);
//    }
//
//    @PostMapping(value = "/update-phone")
//    public String updatePhone(@Validated @ModelAttribute Phone phone, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasFieldErrors()) {
//            return "view/phone/update";
//        } else {
//            redirectAttributes.addFlashAttribute("msg", "Update phone: " + phone.getPhoneName() + " success.");
//            phoneService.save(phone);
//            return "redirect:view/phone/list";
//        }
//    }
//
//    @GetMapping(value = "/delete-phone/{phoneId}")
//    public String deletePhone(@PathVariable Integer phoneId, RedirectAttributes redirectAttributes) {
//        Phone phone = phoneService.findById(phoneId);
//        redirectAttributes.addFlashAttribute("msg", "Delete customer: " + phone.getPhoneName() + "success.");
//        phoneService.delete(phone);
//        return "redirect:view/phone/list";
//    }
}
