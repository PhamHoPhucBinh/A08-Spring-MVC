package com.myshop.Service;

import com.myshop.Bean.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InvoiceService {
    Page<Invoice> findAll(Pageable pageable);

    Iterable<Invoice> findAllNotPage();

    Invoice findById(Integer invoiceId);

    void save(Invoice invoice);

    void delete(Invoice invoice);
}
