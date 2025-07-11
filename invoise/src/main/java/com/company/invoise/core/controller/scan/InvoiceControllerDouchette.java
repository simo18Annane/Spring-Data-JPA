package com.company.invoise.core.controller.scan;

import com.company.invoise.core.controller.InvoiceControllerInterface;
import com.company.invoise.core.entity.Customer;
import com.company.invoise.core.entity.Invoice;
import com.company.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {

    private InvoiceServiceInterface invoiceService;

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Override
    public String createInvoice(Invoice invoice) {
        System.out.println("Usage of a scanner");
        invoice = new Invoice();
        Customer customer = new Customer("Virgin Galactic");
        invoice.setCustomer(customer);
        invoiceService.createInvoice(invoice);
        return null;
    }
}
