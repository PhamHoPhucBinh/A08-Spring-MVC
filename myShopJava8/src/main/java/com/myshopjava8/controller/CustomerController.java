package com.myshopjava8.controller;

import com.myshopjava8.bean.Customer;
import com.myshopjava8.bean.CustomerType;
import com.myshopjava8.service.customer.ICustomerService;
import com.myshopjava8.service.customer.ICustomerServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerServiceType customerServiceType;

    // TODO: 24-May-23 list
    @GetMapping("/customers")
    public ModelAndView listCustomer() {
        Iterable<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    // TODO: 24-May-23 : create
    @GetMapping("/Create-Customer")
    public ModelAndView showCreateForm() {
        Iterable<CustomerType> customerTypes = customerServiceType.findAll();
        ModelAndView modelAndView = new ModelAndView("view/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("customerTypes", customerTypes);
        return modelAndView;
    }

    @PostMapping("/Create-Customer")
    public ModelAndView saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("view/customer/create");
            modelAndView.addObject("customerTypes", customerServiceType.findAll());
//            modelAndView.addObject("message", "NOT ALLOW PHONE NUMBER FORMAT");
            return modelAndView;
        } else {
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("view/customer/create");
            modelAndView.addObject("customer", new Customer());
            modelAndView.addObject("message", "Customer created successfully.");
            return modelAndView;
        }
    }

    // TODO: 24-May-23 : edit
    @GetMapping("/Edit-Customer/{customerId}")
    public ModelAndView showEditForm(@PathVariable Integer customerId) {
        Optional<Customer> customer = customerService.findById(customerId);
        if (customer.isPresent()) {
            Iterable<CustomerType> customerTypes = customerServiceType.findAll();
            ModelAndView modelAndView = new ModelAndView("view/customer/edit");
            modelAndView.addObject("customerTypes", customerTypes);
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/Edit-Customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("view/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    // TODO: 24-May-23 Delete
    @GetMapping("/Delete-Customer/{customerId}")
    public ModelAndView showDeleteForm(@PathVariable Integer customerId) {
        Optional<Customer> customer = customerService.findById(customerId);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("view/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/Delete-Customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getCustomerId());
        return "redirect:/customers";
    }

}
