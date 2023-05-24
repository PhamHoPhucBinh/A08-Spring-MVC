package com.myshop2.service.invoice;

import com.myshop2.bean.Invoice;
import com.myshop2.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public Iterable<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId);
    }

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public void remove(Integer invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }
}
