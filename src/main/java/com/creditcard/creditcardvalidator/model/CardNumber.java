package com.creditcard.creditcardvalidator.model;

public class CardNumber {
    private String cardNumber;

    public CardNumber() {
    }

    public CardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
