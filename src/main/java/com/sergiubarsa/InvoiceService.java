package com.sergiubarsa;

public class InvoiceService {

    public Invoice create(String userId, int amount) {
        return new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
    }
}
