package com.myshop2.service.invoice;

import com.myshop2.bean.Customer;
import com.myshop2.bean.Invoice;

import java.util.Optional;

public interface IInvoiceService {
    Iterable<Invoice> findAll();

    Optional<Invoice> findById(Integer invoiceId);

    void save(Invoice invoice);

    void remove(Integer invoiceId);
}
