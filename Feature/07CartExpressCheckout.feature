@ExpressCheckout @purple1
Feature: Express Checkout Validations

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  Scenario Outline: 1 Verify user able to land on Checkout page after amazon login from Express checkout
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should be able to view " Express Checkout" section in checkout page
    Then user should able to view the options for "Paypal" under Express Checkout section
    Then user should able to view the options for "Amazon Pay" under Express Checkout section
    Then user should able to click on "Amazon Pay" button in express checkout
    Then user should able to login to amazon account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"

    Examples: 
      | Iteration | Product1 | Product2         | Category | Pay Account |
      |         1 | Duvet    | Weighted Blanket | Bedding  | Amazon      |


  Scenario Outline: 2 Verify the payment method is auto selected to amazon pay once user logs in
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the options for "Amazon Pay" under Express Checkout section
    Then user should able to click on "Amazon Pay" button in express checkout
    Then user should able to login to amazon account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should able to view the amazon widget with title as "Address book"
    Then user should able to select the valid address from address book
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to view the payment method will be auto selected to amazon pay and payment widget is displayed
    Then user should able to view the amazon payment widget with title as "Payment method"

    Examples: 
      | Iteration | Product1   | Product2 | Category   | Pay Account |
      |         1 | Foundation | Platform | Bed Frames | Amazon      |

  Scenario Outline: 3 Verify user able to place order using amazon pay express checkout
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the options for "Amazon Pay" under Express Checkout section
    Then user should able to click on "Amazon Pay" button in express checkout
    Then user should able to login to amazon account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should able to view the amazon widget with title as "Address book"
    Then user should able to select the valid address from address book
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to view the amazon payment widget with title as "Payment method"
    Then user should be able to click on complete order button
    Then user able to click Original address if applicable
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the current date
    Then user should be able to view "Billing & Delivery" section in order confirmation page
    Then user should be able to view "Billing" Address in order confirmation page
    Then user should be able to view "Delivery" Address in order confirmation page
    Then user should be able to view "Payment Method" in order confirmation page
    Then user should be able to view "Delivery Method" in order confirmation page
    Then user should be able to view "BACK TO SHOPPING" button
    Then user should able to view Customer service icon
    Then user should able to view Customer service number link
    Then user clicks on Customer service number link

    Examples: 
      | Iteration | Product1               | Product2                       | Category   | Pay Account |
      |         1 | Purple Hybrid Mattress | Purple Hybrid Premier Mattress | Mattresses | Amazon      |

  Scenario Outline: 4 Verify the error message if non us address is selected from amazon addressbook widget
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should be able to view " Express Checkout" section in checkout page
    Then user should able to view the options for "Paypal" under Express Checkout section
    Then user should able to view the options for "Amazon Pay" under Express Checkout section
    Then user should able to click on "Amazon Pay" button in express checkout
    Then user should able to login to amazon account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should able to view the amazon widget with title as "Address book"
    Then user should able to select the invalid address from address book
    Then user should able to view the error message below widget as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Product1   | Product2  | Category   | Pay Account | Error Code |
      |         1 | Foundation | PowerBase | Bed Frames | Amazon      |         14 |

  Scenario Outline: 1 Verify user able to land on Checkout page after paypal login from Express checkout
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should be able to view " Express Checkout" section in checkout page
    Then user should able to click on "Paypal" button in express checkout
    Then user should able to login to paypal account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should be successfully logged in to paypal site
    Then user should able to click the Continue button in the paypal site
    Then user should able to land on Checkout page

    Examples: 
      | Iteration | Product1 | Product2         | Category | Pay Account |
      |         1 | Duvet    | Weighted Blanket | Bedding  | Paypal      |

  Scenario Outline: 2 Verify user able to view the shipping info retained in checkout page when user navigate from paypal site or cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view " Express Checkout" section in checkout page
    Then user should able to view the options for "Paypal" under Express Checkout section
    Then user should able to click on "Paypal" button in express checkout
    Then user should able to login to paypal account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should be successfully logged in to paypal site
    Then user should able to view the Ship to address from paypal
    Then user should able to click the Continue button in the paypal site
    Then user should able to land on Checkout page
    Then user should able to view the address from paypal will be pre populated in the checkout page
    Then user should able to view the payment method will be auto selected to paypal in checkout page
    When user click on Cart Icon
    Then User should able to to view the title of the page as "Cart"
    When user navigates again to "Checkout" page
    Then user should able to see all information already entered should be retained in the checkout page

    Examples: 
      | Iteration | Product1   | Product2 | Category   | Pay Account |
      |         1 | Foundation | Platform | Bed Frames | Paypal      |

  Scenario Outline: 3 Verify user able to view the paypal payment method is auto selected under payment method
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view " Express Checkout" section in checkout page
    Then user should able to click on "Paypal" button in express checkout
    Then user should able to login to paypal account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should be successfully logged in to paypal site
    Then user should able to view the Ship to address from paypal
    Then user should able to click the Continue button in the paypal site
    Then user should able to land on Checkout page
    Then user should able to view the address from paypal will be pre populated in the checkout page
    Then user should able to view the payment method will be auto selected to paypal in checkout page

    Examples: 
      | Iteration | Product1               | Product2                       | Category   | Pay Account |
      |         1 | Purple Hybrid Mattress | Purple Hybrid Premier Mattress | Mattresses | Paypal      |

  Scenario Outline: 4 Verify user able to place the order with Paypal Express checkout option
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view " Express Checkout" section in checkout page
    Then user should able to view the options for "Paypal" under Express Checkout section
    Then user should able to click on "Paypal" button in express checkout
    Then user should able to login to paypal account <Pay Account>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | LoginCreds |
    Then user should be successfully logged in to paypal site
    Then user should able to click the Continue button in the paypal site
    Then user should able to land on Checkout page
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to view the payment method will be auto selected to paypal in checkout page
    Then user should be able to click on complete order button
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation"
    Then user should be able to view the current date
    Then user should be able to view "Billing & Delivery" section in order confirmation page
    Then user should be able to view "Billing" Address in order confirmation page
    Then user should be able to view "Delivery" Address in order confirmation page
    Then user should be able to view "Payment Method" in order confirmation page
    Then user should be able to view "Delivery Method" in order confirmation page

    Examples: 
      | Iteration | Product1   | Product2  | Category   | Pay Account |
      |         1 | Foundation | PowerBase | Bed Frames | Paypal      |
