----------------------------------------------------------Mock API Details---------------------------------------------------------------------------

--> User Registration:-

       Under User Registartion API, User gives the input details then the response is generated as "User Registeration Succesful".
       If the user misses any values while giving the input then the the user will not get registered, the reponse will be status code "401" and the message will be "input details missing".
       If the user did not gives the input then the response will be status code "404" and the message will be "input details not found"

       Input data:-
           {
              "username": "Roy",
              "email": "roy@gmail.com",
              "name": "Roy Walter",
              "address": "USA",
              "phone": "202-555-0118"
           }

        Response:-
            {
               "status": "success",
               "message": "User registration successful",
               "user": {
                         "id": "1",
                         "username": "Roy",
                         "email": "roy@gmail.com",
                         "name": "Roy Walter",
                         "address": "USA",
                         "phone": "202-555-0118"
                       }
            }


--> User Login:-

       Under User Login API, User gives the input details then the response is generated as "User Login Succesful".
       If the user misses any values while giving the input then the the user will not get logged in, the reponse will be status code "401" and the message will be "input details missing".
       If the user did not gives the input then the response will be status code "404" and the message will be "input details not found"

       Input data:-
            {
               "username": "Roy",
               "email": "roy@gmail.com"
            }

        Response:-
             {
               "status": "success",
               "message": "User login successful",
               "user": {
                         "id": "1",
                         "username": "Roy",
                         "email": "roy@gmail.com",
                         "name": "Roy Walter",
                         "address": "USA",
                         "phone": "202-555-0118"
                       }
            }


--> Search Books:-
       
       Under Search Books API, User gives the search critaria as the parameter then the response is generated as per the given search criteria.
       If the user did not gives wrong search criteria while running the API then the the user will get the error reponse and status code "404" and the message will be "no such data found".

        Input data:-
            search = fiction

        Response:-
            [
                {
                  "id": 1,
                  "name": "Treasure Island",
                  "type": "fiction",
                  "available": true
                 },
                 {
                  "id": 2,
                  "name": "The Vanishing Half",
                  "type": "fiction",
                  "available": true
                 },
                 {
                  "id": 3,
                  "name": "Gulliver's Travels",
                  "type": "fiction",
                  "available": true
                 },
                 {
                  "id": 4,
                  "name": "The Hobbit, or, There and Back Again",
                  "type": "fiction",
                  "available": true
                 }
            ]

--> Add to Cart:-
       
       Under Add to cart API, User gives the input details then the response is generated as "item added to the cart".
       If the user misses any values while giving the input then the the items will not get added to cart, the reponse will be status code "401" and the message will be "input details missing".
       If the user did not gives the input then the response will be status code "404" and the message will be "input details not found"

        Input data:-
          {
            "name": "Gulliver's Travels",
            "quantity": 2
          }

        Response:-
          {
            "success": true,
            "message": "Item added to cart",
            "name": "Gulliver's Travels",
            "quantity": 2
          }

--> Checkout:-

       Under Checkout API, User gives the input details then the response is generated as "checkout successful".
       If the user misses any values while giving the input then the the checkout fails, the reponse will be status code "401" and the message will be "input details missing".
       If the user misses payment values while giving the input then the the checkout fails, the reponse will be status code "402" and the message will be "payment method required".
       If the user did not gives the input then the response will be status code "404" and the message will be "input details not found"

       Input data:-
           {
            "cart": [
                       {
                           "id": "4",
                           "name": "Gulliver's Travels",
                           "price": 18,
                           "quantity": 2
                        }
                    ],
           "total_price": 18,
           "customer_info": {
                               "name": "Roy Walter",
                               "email": "roy@gmail.com",
                               "address": "USA",
                               "payment_method": "Credit Card",
                               "card_details": {
                                                  "card_number": "1234 5678 9012",
                                                  "expiration_date": "12/24",
                                                  "cvv": "123"
                                                }
                            }
           }

        Response:-
            {
               "success": true,
               "message": "Checkout successful"
            }
       
