package com.creditcard.creditcardvalidator.model;

public class CreditCard {
    private String number;
    private String expirationDate;

    public CreditCard(String number, String expirationDate) {
        this.number = number;
        this.expirationDate = expirationDate;
    }

    public CreditCard() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
