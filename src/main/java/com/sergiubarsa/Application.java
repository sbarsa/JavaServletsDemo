package com.sergiubarsa;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Application {

    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final InvoiceService invoiceService = new InvoiceService();
}
