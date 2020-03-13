package com.creditcard.creditcardvalidator.model;

import java.util.List;

public class BlackListedCard {
    private String cardNumber;

    public BlackListedCard() {
    }

    public BlackListedCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
