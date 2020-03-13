package com.creditcard.creditcardvalidator.service;

import com.creditcard.creditcardvalidator.model.CardNumber;
import com.creditcard.creditcardvalidator.model.CreditCard;
import com.creditcard.creditcardvalidator.resources.CreditCardResources;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    public List<CreditCard> getCreditAllCards(){
        return new CreditCardResources().getCreditCards();
    }

    public List<CardNumber> getAllBlackListedCards(){
        return new CreditCardResources().getBlacklistedCards();
    }
}
