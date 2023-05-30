package com.myshopjava8.controller;

import com.myshopjava8.DTO.InvoiceDTO;
import com.myshopjava8.bean.Customer;
import com.myshopjava8.bean.Invoice;
import com.myshopjava8.bean.InvoiceDetails;
import com.myshopjava8.bean.Phone;
import com.myshopjava8.service.customer.CustomerService;
import com.myshopjava8.service.invoice.InvoiceDetailsService;
import com.myshopjava8.service.invoice.InvoiceService;
import com.myshopjava8.service.phone.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InvoiceController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @ModelAttribute("customers")
    public Iterable<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    @ModelAttribute("phones")
    public Iterable<Phone> findAllPhone() {
        return phoneService.findAll();
    }

    @GetMapping("/invoices")
    public ModelAndView listInvoice() {
        Iterable<Invoice> invoices = invoiceService.findAll();
        ModelAndView modelAndView = new ModelAndView("view/invoice/listInvoice");
        if (invoices == null) {
            modelAndView.addObject("message", "Chưa có khách hàng nào sử dụng dịch vụ.");
        }
        modelAndView.addObject("invoices", invoices);
        return modelAndView;
    }

//    @GetMapping("/invoice-form/")
//    public ModelAndView showInvoiceForm(@PathVariable Integer phoneId) {
//        ModelAndView modelAndView = new ModelAndView("view/invoice/createInvoice");
//        InvoiceDTO invoiceDTO = new InvoiceDTO();
//        modelAndView.addObject("invoiceDTO", invoiceDTO);
//        return modelAndView;
//    }

    @PostMapping(value = "/createInvoice")
    public String saveContract(@Validated @ModelAttribute Invoice invoice, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "view/invoice/invoice-form";
        } else {
            redirectAttributes.addFlashAttribute("message", "Create contract of customer: " + invoice.getCustomer().getCustomerName() + " success.");
            invoiceService.save(invoice);
            return "redirect:view/phone/list";
        }
    }

    @GetMapping(value = "/createInvoiceDetails")
    public String showPageCreateInvoiceDetails(Model model) {
        model.addAttribute("contract", invoiceService.findAll());
        model.addAttribute("contractDetail", new InvoiceDetails());
        return "view/invoice/createInvoiceDetails";
    }

    @PostMapping(value = "/createContractDetail")
    public String saveInvoiceDetail(@ModelAttribute InvoiceDetails invoiceDetails, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Create success.");
        invoiceDetailsService.save(invoiceDetails);
        return "redirect:/contract/show";
    }
}
