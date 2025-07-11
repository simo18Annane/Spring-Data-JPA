package com.company.invoise.core.controller;

import com.company.invoise.core.entity.Invoice;
import com.company.invoise.core.service.InvoiceServiceInterface;

public interface InvoiceControllerInterface {
    String createInvoice(Invoice invoice);
    void setInvoiceService(InvoiceServiceInterface invoiceService);
}
