package com.creditcard.creditcardvalidator.utilities;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static boolean isCreditCard(String cardNumber) {
        int sum = 0;

        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = n % 10 + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return sum % 10 == 0;
    }

    public static boolean checkIfDateIsInFuture(String dateMMYY) {
        dateMMYY = "01/" + dateMMYY;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate lt = LocalDate.parse(dateMMYY, dtf);
        LocalDate now = LocalDate.now();
        return lt.isAfter(now);
    }

    public static boolean isVisa(String cardNumber) {
        return cardNumber.length() == 16
                && cardNumber.substring(0, 1).equals("4");
    }

    public static boolean isMastercard(String cardNumber) {
        return cardNumber.length() == 16
                && cardNumber.substring(0, 1).equals("5")
                && (Integer.parseInt(cardNumber.substring(1, 2)) >= 1
                && Integer.parseInt(cardNumber.substring(1, 2)) <= 5);
    }

    public static boolean isAmericanExpress(String cardNumber) {
        return cardNumber.length() == 15
                && cardNumber.substring(0, 1).equals("3")
                && (cardNumber.substring(1, 2).equals("4") || cardNumber.substring(1, 2).equals("7"));
    }

    public static boolean isDinersClub(String cardNumber) {
        return cardNumber.length() == 14
                && cardNumber.substring(0, 1).equals("3")
                && (cardNumber.substring(1, 2).equals("0") || cardNumber.substring(1, 2).equals("6") || cardNumber.substring(1, 2).equals("8"));
    }

    public static boolean isCarteBlanche(String cardNumber) {
        return isDinersClub(cardNumber);
    }

    public static boolean isDiscover(String cardNumber) {
        return cardNumber.length() == 16
                && cardNumber.substring(0, 4).equals("6011");
    }

    public static boolean isEnRoute(String cardNumber) {
        return cardNumber.length() == 15
                && (cardNumber.substring(0, 4).equals("2014")
                || cardNumber.substring(0, 4).equals("2149"));
    }

    public static boolean isJCB(String cardNumber) {
        String first4Digits = cardNumber.substring(0, 4);
        return cardNumber.length() == 16
                && (first4Digits.equals("3088")
                || first4Digits.equals("3096")
                || first4Digits.equals("3112")
                || first4Digits.equals("3158")
                || first4Digits.equals("3337")
                || first4Digits.equals("3528"));
    }

    public static boolean isAnyCard(String cardNumber) {
        return !(!isCreditCard(cardNumber)
                || (!isMastercard(cardNumber)
                && !isVisa(cardNumber)
                && !isAmericanExpress(cardNumber)
                && !isDinersClub(cardNumber)
                && !isDiscover(cardNumber)
                && !isEnRoute(cardNumber)
                && !isJCB(cardNumber)));
    }

    public static boolean isCardMatch(String cardNumber, String cardType) {
        cardType = cardType.toUpperCase();
        switch (cardType) {
            case "VISA":
                return isVisa(cardNumber);
            case "MASTERCARD":
                return isMastercard(cardNumber);
            case "AMEX":
            case "AMERICANEXPRESS":
                return isAmericanExpress(cardNumber);
            case "DISCOVER":
                return isDiscover(cardNumber);
            case "JCB":
                return isJCB(cardNumber);
            case "DINERS":
                return isDinersClub(cardNumber);
            case "CARTEBLANCHE":
                return isCarteBlanche(cardNumber);
            case "ENROUTE":
                return isEnRoute(cardNumber);
            default:
                return false;
        }
    }

    public static String getCardType(String cardNumber) {
        String cardType;

        if (isVisa(cardNumber)) cardType = "VISA";
        else if (isMastercard(cardNumber)) cardType = "MASTERCARD";
        else if (isAmericanExpress(cardNumber)) cardType = "AMERICANEXPRESS";
        else if (isDiscover(cardNumber)) cardType = "DISCOVER";
        else if (isJCB(cardNumber)) cardType = "JCB";
        else if (isDinersClub(cardNumber)) cardType = "DINERS";
        else if (isCarteBlanche(cardNumber)) cardType = "CARTEBLANCHE";
        else if (isEnRoute(cardNumber)) cardType = "ENROUTE";
        else cardType = "Invalid Card Type";

        return cardType;
    }

    public static String getDigits(String cardNumber) {
        return cardNumber.replaceAll("[^0-9]", "");
    }

    public static void main(String[] args) {
        System.out.println(getDigits("4788 3845 3855 2447"));
    }
}
