package com.creditcard.creditcardvalidator.resources;

import com.creditcard.creditcardvalidator.model.Validation;

import java.util.List;

public class Validations {
    private List<Validation> validCards;

    public Validations(List<Validation> validCards) {
        this.validCards = validCards;
    }

    public List<Validation> getValidCards() {
        return validCards;
    }

    public void setValidCards(List<Validation> validCards) {
        this.validCards = validCards;
    }
}
