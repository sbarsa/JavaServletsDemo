package com.sergiubarsa;

import java.util.UUID;

public class Invoice {
    private String id;
    private String userId;
    private String pdfUrl;
    private int amount;

    public Invoice(String userId, int amount, String pdfUrl) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.pdfUrl = pdfUrl;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
