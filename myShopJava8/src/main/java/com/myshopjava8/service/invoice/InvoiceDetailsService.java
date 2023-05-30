package com.myshopjava8.service.invoice;

import com.myshopjava8.bean.Invoice;
import com.myshopjava8.bean.InvoiceDetails;
import com.myshopjava8.repository.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailsService implements IInvoiceDetailsService {
    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    @Override
    public InvoiceDetails findByIdInvoice(Invoice invoice) {
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
