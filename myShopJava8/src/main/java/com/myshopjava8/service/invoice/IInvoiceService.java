package com.myshopjava8.service.invoice;


import com.myshopjava8.bean.Invoice;

import java.util.Optional;

public interface IInvoiceService {
    Iterable<Invoice> findAll();

    Optional<Invoice> findById(Integer invoiceId);

    void save(Invoice invoice);

    void remove(Integer invoiceId);
}
