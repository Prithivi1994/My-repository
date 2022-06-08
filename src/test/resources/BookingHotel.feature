Feature: Booking Adactin Hotel

  Scenario Outline: Booking Adactin Hotel by valid credential
    #Given User is in adactin login page
    #When User should perform login
    And User should verify "Hello Prithivi402!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    And User should verify text "Select Hotel"
    And User should select hotel
    And User should confirm "Book A Hotel"
    And User should book hotel "<firstName>","<lastName>","<billingAddress>", payment details and book hotel
      | Credit Card Type | Credit Card No   | Select Month | Select Year | cvv |
      | Master Card      | 5464651254125451 | February     |        2022 | 123 |
      | VISA             | 3464651254178941 | March        |        2022 | 321 |
      | Master Card      | 6461465125414512 | August       |        2022 | 456 |
      | Master Card      | 8464651255151611 | May          |        2022 | 789 |
    Then User should verify booking "Booking Confirmation"

    Examples: 
      | location | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | London   | Hotel Creek | Standard | 1 - One    | 19/05/2022  | 21/05/2022   | 2 - Two       | 2 - Two         | prithivi  | raj      | chennai        |

  Scenario Outline: Booking Adactin Hotel without entering any fields in Book Now Page
    #Given User is in adactin login page
    #When User should perform login
    And User should verify "Hello Prithivi402!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    And User should verify text "Select Hotel"
    And User should select hotel
    And User should confirm "Book A Hotel"
    And User should click on Book Now
    Then User should verify error messages "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | location | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | London   | Hotel Creek | Standard | 1 - One    | 19/05/2022  | 21/05/2022   | 2 - Two       | 2 - Two         |
