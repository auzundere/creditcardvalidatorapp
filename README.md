# creditcardvalidatorapp
## TO RUN THE APPLICATION

## On terminal/command prompt

1. mvn spring-boot:run
2. Go to a browser and type http://localhost:8080/ (to see all credit cards in the hardcoded cards)
3. /{cardType} -> Ex. cardType = visa, mastercard, discovery, diner, etc... http://localhost:8080/visa (it gets the card numbers from the inventory(hard coded)) 
4. /{number}/{month}/{year} -> number -> card number (with or w/o space, dash etc), month  -> 2 digits month like 08, year -> 2 digits year like 20