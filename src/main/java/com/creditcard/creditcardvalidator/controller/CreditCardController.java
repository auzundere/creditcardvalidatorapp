package com.creditcard.creditcardvalidator.controller;

import com.creditcard.creditcardvalidator.model.*;
import com.creditcard.creditcardvalidator.resources.BlackListCards;
import com.creditcard.creditcardvalidator.resources.ExpiredCards;
import com.creditcard.creditcardvalidator.resources.InvalidCards;
import com.creditcard.creditcardvalidator.resources.Validations;
import com.creditcard.creditcardvalidator.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.creditcard.creditcardvalidator.utilities.Utils.*;

@RestController
@RequestMapping("/cc")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CreditCard>> getAllResults() {
        return new ResponseEntity(creditCardService.getCreditAllCards(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{cardType}", method = RequestMethod.GET)
    public ResponseEntity getValidation(@PathVariable("cardType") String cardType) {
        List<Object> response = new ArrayList<>();
        List<String> blacklistedCardNumbers = new ArrayList<>();
        List<ExpiredCard> expiredCardsList = new ArrayList<>();
        List<InvalidCard> invalidCardsList = new ArrayList<>();
        List<BlackListedCard> blackListedCards = new ArrayList<>();
        List<Validation> validCardsList = new ArrayList<>();

        AtomicInteger i = new AtomicInteger();
        creditCardService.getAllBlackListedCards().stream().map(
                card -> blacklistedCardNumbers.add(card.getCardNumber().replaceAll("-", "").replaceAll(" ", ""))).collect(Collectors.toList());
        List<CreditCard> creditCards = creditCardService.getCreditAllCards();

        for (CreditCard creditCard : creditCards) {

            String credit_card = creditCard.getNumber();
            String cc = credit_card.replaceAll(" ", "").replaceAll("-", "");

            if (blacklistedCardNumbers.contains(cc)) {
                blackListedCards.add(new BlackListedCard(credit_card));
                continue;
            }
            if (!isCardMatch(cc, cardType)) {
                invalidCardsList.add(new InvalidCard(credit_card));
            } else if (!checkIfDateIsInFuture(creditCard.getExpirationDate())) {
                expiredCardsList.add(new ExpiredCard(credit_card, cardType));
            } else {
                validCardsList.add(new Validation(credit_card, cardType));
            }
        }

        BlackListCards blc = new BlackListCards(blackListedCards);
        ExpiredCards expiredCards = new ExpiredCards(expiredCardsList);
        Validations validCards = new Validations(validCardsList);
        InvalidCards invalidCards = new InvalidCards(invalidCardsList);

        if (validCardsList.size() > 0) response.add(validCards);
        if (expiredCardsList.size() > 0) response.add(expiredCards);
        if (blackListedCards.size() > 0) response.add(blc);
        if (invalidCardsList.size() > 0) response.add(invalidCards);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
