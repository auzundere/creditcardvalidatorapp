# creditcardvalidatorapp

## TO RUN THE APPLICATION

## On terminal/command prompt

1. mvn spring-boot:run
2. Go to a browser and type http://localhost:8080/ (to see all credit cards in the hardcoded cards)
```[
   {
      "number":"4788 3845 3855 2446",
      "expirationDate":"08/22"
   },
   {
      "number":"4788 3845 3855 2447",
      "expirationDate":"04/20"
   },
   {
      "number":"5144-2233-5566-8876",
      "expirationDate":"08/22"
   },
   {
      "number":"6144 3854 3852 3845",
      "expirationDate":"01/20"
   },
   {
      "number":"5144 3854 3852 3845",
      "expirationDate":"08/22"
   },
   {
      "number":"5424 0217 2495 6181",
      "expirationDate":"08/22"
   },
   {
      "number":"3400 0000 0000 009",
      "expirationDate":"08/22"
   }
]
```
3. /{cardType} -> Ex. cardType = visa, mastercard, discovery, diner, etc... http://localhost:8080/visa (it gets the card numbers from the inventory(hard coded))
```[
   {
      "validCards":[
         {
            "cardNumber":"4788 3845 3855 2447",
            "type":"visa"
         }
      ]
   },
   {
      "blackListedCards":[
         {
            "cardNumber":"4788 3845 3855 2446"
         },
         {
            "cardNumber":"5144 3854 3852 3845"
         },
         {
            "cardNumber":"5424 0217 2495 6181"
         }
      ]
   },
   {
      "invalidCards":[
         {
            "cardNumber":"5144-2233-5566-8876"
         },
         {
            "cardNumber":"6144 3854 3852 3845"
         },
         {
            "cardNumber":"3400 0000 0000 009"
         }
      ]
   }
]
```
4. /{number}/{month}/{year} -> number -> card number (with or w/o space, dash etc), month  -> 2 digits month like 08, year -> 2 digits year like 20
    Example: http://localhost:8080/4788-3845-3855-2447/04/20
    It will return 
   ``` [
        {
            "validCards": [
                    {
                        "cardNumber": "4788 3845 3855 2447",
                        "type": "VISA"
                    }
            ]
        }
    ]
```