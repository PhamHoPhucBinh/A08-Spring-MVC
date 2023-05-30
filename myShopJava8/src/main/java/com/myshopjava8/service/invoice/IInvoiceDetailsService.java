package com.myshopjava8.service.invoice;

import com.myshopjava8.bean.Invoice;
import com.myshopjava8.bean.InvoiceDetails;

public interface IInvoiceDetailsService {
    InvoiceDetails findByIdInvoice(Invoice invoice);

    void save(InvoiceDetails invoiceDetails);

    void remove(Invoice invoice);
}
