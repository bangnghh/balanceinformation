package com.erpconnect.model;

public class RequestModel {
    private String bank_id;
    private String customer_id;
    private String account_id;
    private String signature;

    public RequestModel() {
    }

    public RequestModel(String bank_id, String customer_id, String account_id, String signature) {
        this.bank_id = bank_id;
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.signature = signature;
    }

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
