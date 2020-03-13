package com.creditcard.creditcardvalidator.resources;

import com.creditcard.creditcardvalidator.model.InvalidCard;

import java.util.List;

public class InvalidCards {
    private List<InvalidCard> invalidCards;

    public InvalidCards(List<InvalidCard> invalidCards) {
        this.invalidCards = invalidCards;
    }

    public List<InvalidCard> getInvalidCards() {
        return invalidCards;
    }

    public void setInvalidCards(List<InvalidCard> invalidCards) {
        this.invalidCards = invalidCards;
    }
}
