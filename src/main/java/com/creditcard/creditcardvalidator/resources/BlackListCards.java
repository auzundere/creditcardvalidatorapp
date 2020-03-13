package com.creditcard.creditcardvalidator.resources;

import com.creditcard.creditcardvalidator.model.BlackListedCard;

import java.util.List;

public class BlackListCards {
    private List<BlackListedCard> blackListedCards;

    public BlackListCards(List<BlackListedCard> blackListedCards) {
        this.blackListedCards = blackListedCards;
    }

    public List<BlackListedCard> getBlackListedCards() {
        return blackListedCards;
    }

    public void setBlackListedCards(List<BlackListedCard> blackListedCards) {
        this.blackListedCards = blackListedCards;
    }
}
