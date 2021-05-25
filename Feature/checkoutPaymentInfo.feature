@PaymentInfo @purple1
Feature: Payment Types and Description

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-2757
  Scenario Outline: 1 Ability of the user to view all the payment method with credit card type as auto selected
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the credit card payment is selected by default
    And user should able to view the "affirm" payment option
    And user should able to view the "splitit" payment option
    And user should able to view the "paypal" payment option
    And user should able to view the "amazonpay" payment option

    Examples: 
      | Iteration | Product1       | Product2      | Category |
      |         1 | Purple Harmony | Purple Pillow | Pillows  |

  Scenario Outline: 2 Verify the user able to view the one liner text to Affirm and splitit payment method in expand and collapsed state
    Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on keep shopping button
    #Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the affirm one liner as "Monthly Payments with as low as 0% APR financing."
    Then user should able to view the splitit one liner as "Monthly payments using your credit card at 0% interest."

    Examples: 
      | Iteration | Product1       | Product2      | Category |
      |         1 | Purple Harmony | Purple Pillow | Pillows  |

  Scenario Outline: 3 Verify Expanding one payment method should collapse the already open payment method
    Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on keep shopping button
    #Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the credit card payment is selected by default
    Then user should able to expand "affirm" payment option and collapse "card" payment option
    Then user should able to expand "splitit" payment option and collapse "affirm" payment option
    Then user should able to expand "paypal" payment option and collapse "splitit" payment option
    Then user should able to expand "amazonpay" payment option and collapse "paypal" payment option
    Then user should able to expand "card" payment option and collapse "amazonpay" payment option

    Examples: 
      | Iteration | Product1       | Product2      | Category |
      |         1 | Purple Harmony | Purple Pillow | Pillows  |

  Scenario Outline: 4 Verify the total payable amount is displayed for Credit card, Paypal and Amazon options
    Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on keep shopping button
    #Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to view the total payable amount for "card" same as in order summary
    Then user should able to view the total payable amount for "paypal" same as in order summary
    Then user should able to view the total payable amount for "amazonpay" same as in order summary

    Examples: 
      | Iteration | Product1       | Product2      | Category |
      |         1 | Purple Harmony | Purple Pillow | Pillows  |

  
  Scenario Outline: 5 Verfiy the credit card field error message for empty fields
    Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on keep shopping button
    #Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to click on complete order button
    Then user should able to view the error message for credit card "name" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for credit card "card" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for credit card "exp" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for credit card "cvv" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Error Code | Product1       | Product2      | Category |
      |         18 | Purple Harmony | Purple Pillow | Pillows  |


  Scenario Outline: 6 Verfiy the credit card field error message for invalid card number and expiry date
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user enters the "Full Name" <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user enters the "Credit Card Number" <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user enters the "Expiration Date" <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user enters the "CVV" <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should able to view the error message for invalid credit card "card" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for invalid credit card "exp" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Error Code | Product1       | Category |
      |         11 |         20 | Purple Harmony | Pillows  |

  
  Scenario Outline: 6 Verfiy the UI when all the payment method is expanded
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the credit card payment is selected by default
    Then user should able to expand "affirm" payment option and collapse "card" payment option
    Then user should able to view "affirm" wallet icon with text as "you will be redirected to Affirm's website to complete your purchase securely."
    Then user should able to expand "splitit" payment option and collapse "affirm" payment option
    Then user should able to view "splitit" wallet icon with text as "you will be redirected to Splitit's website to complete your purchase securely."
    Then user should able to expand "paypal" payment option and collapse "splitit" payment option
    Then user should able to view "paypal" wallet icon with text as "you will be redirected to Paypal's website to complete your purchase securely."
    Then user should able to expand "amazonpay" payment option and collapse "paypal" payment option
    Then user should able to view "amazon" wallet icon with text as "you will be redirected to Amazon's website to complete your purchase securely."

    Examples: 
      | Iteration | Product1       |  Category |
      |         1 | Purple Harmony | Pillows  |


  Scenario Outline: 7 Verfiy the behaviour of learn more link of splitit payment option
   Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the credit card payment is selected by default
    Then user should able to expand "affirm" payment option and collapse "card" payment option
    Then user should able to open affirm popup in payment method
    Then user should able to view affirm popup
    Then user should able to close the affirm popup
    
    Examples: 
      | Iteration | Product1       |  Category |
      |         1 | Purple Harmony | Pillows  |
