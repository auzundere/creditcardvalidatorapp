package com.creditcard.creditcardvalidator.model;

public class ExpiredCard {
    private String cardNumber;
    private String type;

    public ExpiredCard() {
    }

    public ExpiredCard(String cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
