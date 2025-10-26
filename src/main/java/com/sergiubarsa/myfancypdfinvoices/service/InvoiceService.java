package com.sergiubarsa.myfancypdfinvoices.service;

import com.sergiubarsa.myfancypdfinvoices.context.Application;
import com.sergiubarsa.myfancypdfinvoices.model.Invoice;
import com.sergiubarsa.myfancypdfinvoices.model.User;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    private final List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public Invoice create(String userId, int amount) {
        User user = Application.userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);

        return invoice;
    }

    public List<Invoice> findAll() {
        return Collections.unmodifiableList(invoices);
    }
}
