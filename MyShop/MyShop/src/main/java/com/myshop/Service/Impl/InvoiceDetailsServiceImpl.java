package com.myshop.Service.Impl;

import com.myshop.Bean.Invoice;
import com.myshop.Bean.InvoiceDetails;
import com.myshop.Repository.IInvoiceDetailsRepository;
import com.myshop.Service.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailsServiceImpl implements InvoiceDetailsService {

    @Autowired
    private IInvoiceDetailsRepository invoiceDetailsRepository;

    @Override
    public InvoiceDetails findByInvoiceId(Invoice invoice) {
        return invoiceDetailsRepository.findByInvoice(invoice);
    }

    @Override
    public void save(InvoiceDetails invoiceDetails) {
        invoiceDetailsRepository.save(invoiceDetails);
    }

    @Override
    public void remove(Invoice invoice) {
        invoiceDetailsRepository.delete(invoiceDetailsRepository.findByInvoice(invoice));
    }
}
