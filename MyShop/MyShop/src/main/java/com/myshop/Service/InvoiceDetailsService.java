package com.myshop.Service;

import com.myshop.Bean.Invoice;
import com.myshop.Bean.InvoiceDetails;

public interface InvoiceDetailsService {
    InvoiceDetails findByInvoiceId(Invoice invoice);

    void save(InvoiceDetails invoiceDetails);

    void remove(Invoice invoice);
}
