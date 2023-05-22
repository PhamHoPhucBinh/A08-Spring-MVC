package com.myshop.Repository;

import com.myshop.Bean.Invoice;
import com.myshop.Bean.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvoiceDetailsRepository extends JpaRepository<InvoiceDetails,Integer> {
    InvoiceDetails findByInvoice(Invoice invoice);
}
