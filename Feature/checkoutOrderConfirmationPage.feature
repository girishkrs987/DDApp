@OrderConfirmation @purple1
Feature: Order Confirmation Page Validations

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-791 
  Scenario Outline: Verify the UI of Order corfirmation page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
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
    Then user should be able to click on complete order button
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the current date
    Then user should be able to view the same products added to cart "<Product1>"
    Then user should be able to view the same products added to cart "<Product2>"
    Then user should be able to view "Your Order" section in order confirmation page
    Then user should be able to view "Summary" section in order confirmation page
    Then user should be able to view "Billing & Delivery" section in order confirmation page

    Examples: 
      | Iteration | Product1               | Product2                       | Category   | Payment Method |
      |         1 | Purple Hybrid Mattress | Purple Hybrid Premier Mattress | Mattresses | card           |

  
  Scenario Outline: 2 Verify if user is able to view Your Order section with product which has no free gifts
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
    Then user completes the Splitit payment process <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the current date
    Then user should be able to view "Your Order" section in order confirmation page
    Then user should be able to view "Summary" section in order confirmation page
    Then user should be able to view "Billing & Delivery" section in order confirmation page
    Then user should be able to view the same products added to cart "<Product1>"
    And user should not able to view the title as "Free Gift With" product category
    Then user should be able to view the count of the number of products in the order

    #Then user should be able to view product image, product name and price for each of the products in the order
    Examples: 
      | Iteration | Product1   | Category   | Payment Method |
      |         1 | Foundation | Bed Frames | splitit        |

  Scenario Outline: 3 Verify if user is able to view Your Order section in Order Confirmation page with free gits products
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
    Then user able to click Original address if applicable
    Then user completes the Affirm payment process <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the same products added to cart "<Product1>"
    Then user should be able to view the same products added to cart "<Product2>"
    And user should be able to view the title as "Free Gift With" product category

    #And user should be able to view the quantity field in the free gifts products group
    Examples: 
      | Iteration | Product1                  | Product2 | Category | Payment Method |
      |         1 | Purple SoftStretch Sheets | Duvet    | Bedding  | affirm         |

  Scenario Outline: 4 Verify if user is able to view Summary section in Order confirmation page with a product which has no promo code and gift card
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
    Then user completes the Affirm payment process <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the same products added to cart "<Product1>"
    Then user should be able to view the same products added to cart "<Product2>"

    Examples: 
      | Iteration | Product1  | Product2   | Category   | Payment Method |
      |         1 | PowerBase | Foundation | Bed Frames | affirm         |

  Scenario Outline: 5 Verify if user is able to view Summary section in Order confirmation page with a product which has promo code
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
   Then user should able to view "Add Promo Code" link below order summary section
    Then user should able to click "Add Promo Code" link
    And user should be able to enter a promocode in the field as <PromoCode>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | Promocodes |
    And the offer should be applied Successfully
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    #Then user should able to select the payment method as "<Payment Method>"
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
    Then user should be able to click on complete order button
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the current date
    Then user should be able to view "Your Order" section in order confirmation page
    Then user should able to view the promocode line item is displayed

    Examples: 
      | Iteration | Product1       | Product2      | Category | Payment Method | PromoCode |
      |         1 | Purple Harmony | Purple Pillow | Pillows  | card           |         1 |

  Scenario Outline: 6 Verify is user is able to view the order id and a note below the Order confirmation title
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
    Then user completes the Affirm payment process <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the order id in the status bar
    Then user should be able to view the order status in the status bar
    Then user should be able to view a note below the order confirmation title

    Examples: 
      | Iteration | Product1       | Product2      | Category | Payment Method |
      |         1 | Purple Harmony | Purple Pillow | Pillows  | affirm         |

  Scenario Outline: 7 Verify if user is able to view the Billing and Delivery Section in order confirmation page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
    Then user completes the Splitit payment process <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the current date
    Then user should be able to view "Billing & Delivery" section in order confirmation page
    Then user should be able to view "Billing" Address in order confirmation page
    Then user should be able to view "Delivery" Address in order confirmation page
    Then user should be able to view "Payment method" in order confirmation page
    Then user should be able to view "Delivery method" in order confirmation page
    Then user should be able to view "BACK TO SHOPPING" button
    Then user should able to view Customer service icon
    Then user should able to view Customer service number link
    Then user clicks on Customer service number link

    Examples: 
      | Iteration | Product1               | Product2                       | Category   | Payment Method |
      |         1 | Purple Hybrid Mattress | Purple Hybrid Premier Mattress | Mattresses | splitit        |
