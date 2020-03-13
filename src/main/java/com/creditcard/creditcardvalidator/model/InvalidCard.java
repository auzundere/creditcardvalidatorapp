package com.creditcard.creditcardvalidator.model;

public class InvalidCard {
    private String cardNumber;

    public InvalidCard() {
    }

    public InvalidCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
