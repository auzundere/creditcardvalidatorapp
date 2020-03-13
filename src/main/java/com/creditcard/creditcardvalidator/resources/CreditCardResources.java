package com.creditcard.creditcardvalidator.resources;

import com.creditcard.creditcardvalidator.model.CardNumber;
import com.creditcard.creditcardvalidator.model.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardResources {
    private List<CreditCard> creditCards;
    private List<CreditCard> blacklistedCards;

    public CreditCardResources() {

    }

    public List<CreditCard> getCreditCards() {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(new CreditCard("4788 3845 3855 2446", "08/22"));
        creditCards.add(new CreditCard("4788 3845 3855 2447", "04/20"));
        creditCards.add(new CreditCard("5144-2233-5566-8876", "08/22"));
        creditCards.add(new CreditCard("6144 3854 3852 3845", "01/20"));
        creditCards.add(new CreditCard("5144 3854 3852 3845", "08/22"));
        creditCards.add(new CreditCard("5424 0217 2495 6181", "08/22"));
        creditCards.add(new CreditCard("3400 0000 0000 009", "08/22"));

        return creditCards;
    }

    public List<CardNumber> getBlacklistedCards() {
        List<CardNumber> blacklistedCards = new ArrayList<>();
        blacklistedCards.add(new CardNumber("4788 3845 3855 2446"));
        blacklistedCards.add(new CardNumber("5144 3854 3852 3845"));
        blacklistedCards.add(new CardNumber("5424 0217 2495 6181"));
        return blacklistedCards;
    }

}
