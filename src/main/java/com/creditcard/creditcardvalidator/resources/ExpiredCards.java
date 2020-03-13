package com.creditcard.creditcardvalidator.resources;

import com.creditcard.creditcardvalidator.model.ExpiredCard;

import java.util.List;

public class ExpiredCards {
    private List<ExpiredCard> expiredCards;

    public ExpiredCards(List<ExpiredCard> expiredCards) {
        this.expiredCards = expiredCards;
    }

    public List<ExpiredCard> getExpiredCards() {
        return expiredCards;
    }

    public void setExpiredCards(List<ExpiredCard> expiredCards) {
        this.expiredCards = expiredCards;
    }
}
