package com.company.invoise.core.service;

import com.company.invoise.core.entity.Invoice;
import com.company.invoise.core.repository.InvoiceRepositoryInterface;

import java.util.Iterator;
import java.util.List;

public interface InvoiceServiceInterface {
    Invoice createInvoice(Invoice invoice);
    Iterable<Invoice> getInvoiceList();
    Invoice getInvoiceByNumber(String number);
    void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository);
}
