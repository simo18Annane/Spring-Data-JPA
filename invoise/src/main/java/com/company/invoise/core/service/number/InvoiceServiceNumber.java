package com.company.invoise.core.service.number;

import com.company.invoise.core.entity.Invoice;
import com.company.invoise.core.repository.CustomerRepositoryInterface;
import com.company.invoise.core.repository.InvoiceRepositoryInterface;
import com.company.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceServiceNumber implements InvoiceServiceInterface {

    @Autowired //pour l'injection
    private InvoiceRepositoryInterface invoiceRepository;

    @Autowired
    private CustomerRepositoryInterface customerRepository;

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        customerRepository.save(invoice.getCustomer());
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceByNumber(String number) {
        return invoiceRepository.findById(number).orElseThrow();
    }

    @Override
    public Iterable<Invoice> getInvoiceList() {
        /*Iterable<Invoice> invoices = invoiceRepository.findAll();
        //Ceci permet d'inititialiser le client de chaque facture
        invoices.forEach(invoice -> invoice.getCustomer().getName());*/ //Initialisation du proxy au niveau du service
        return invoiceRepository.findAll();
    }
}
