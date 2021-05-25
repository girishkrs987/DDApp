@ShippingInfo @purple1
Feature: Shipping Info

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-613
  Scenario Outline: 1 Verify user able to view the Title section of Checkout and Shipping info Feilds and Labels
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user able to view "Phone" Field with same label
    Then user able to view "Email" Field with same label
    Then user able to view "First Name" Field with same label
    Then user able to view "Last Name" Field with same label
    Then user able to view "Street address, house number" Field with same label
    Then user able to view "Apartment number, unit, floor, etc." Field with same label
    Then user able to view "City" Field with same label
    Then user able to view "Zip" Field with same label
    Then user able to view "State" dropdown with same label
    Then user able to view "Country" dropdown with same label

    Examples: 
      Examples:

      | Iteration | Product1   | Product2  | Category   |
      |         1 | Foundation | PowerBase | Bed Frames |

  Scenario Outline: 2 Verify user able to fill all the shipping info Fields
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Firstname and Lastname <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Address <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter City state and zipcode <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |

    Examples: 
      | Iteration | Product1        | Product2                       | Category   |
      |         1 | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 3 Verify user is able to view the Address suggestion popup for the close matches
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Firstname and Lastname <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Address <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter City state and zipcode <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
    Then user able to view suggestion popup
    Then user able to view the popup title as "Please select shipping address"
    Then user able to view the popup message as "We’re unable to verify your shipping address, but we found a close match. Please select an option below."
    Then user able to view suggested address
    Then user able to view Original address

    Examples: 
      | Iteration | Product1 | Product2         | Category | Payment Method |
      |         3 | Duvet    | Weighted Blanket | Bedding  | affirm         |

  Scenario Outline: 4 Verify the Error message when invalid zip code is entered against the state
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Firstname and Lastname <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Address <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter City state and zipcode <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to view the error message for zipcode against the state <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Error Code | Product1   | Category   |
      |         4 |         12 | Foundation | Bed Frames |

  Scenario Outline: 5 Verify the Inline Error message for Mandatory fields
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to click on complete order button
    Then user should able to view the error message for "firstname" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "lastname" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "address" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "city" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "zipcode" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "state" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "phone" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |
    Then user should able to view the error message for "email" field as <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Error Code | Product1   | Category   |
      |          8 | Foundation | Bed Frames |

  Scenario Outline: 6 Verify Inline Error message for Invalid format of Zipcode
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Firstname and Lastname <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Address <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user enters invalid zipcode
    Then user should able to select the payment method as "<Payment Method>"
    Then user able to view the error message for invalid zipcode <Error Code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Error Code | Product1        | Category   | Payment Method |
      |         4 |          9 | Purple Mattress | Mattresses | affirm         |

  @REP-2641
  Scenario Outline: 7, 8 ,9 Verify Inline Error message for various Invalid format of Email
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user able to view the error message for invalid email <Validation code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Validation code | Product1        | Category   |
      |         7 |               5 | Foundation      | Bed Frames |
      |         8 |               6 | Purple Mattress | Mattresses |
      |         9 |               7 | Foundation      | Bed Frames |

  # Sprint #3
  Scenario Outline: 10 Verify Inline Error message for Invalid format of first name
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Firstname and Lastname <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to click on complete order button
    Then user should able to view the error message for invalid "firstname" field as <Validation code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Validation code | Product1   | Category   |
      |        10 |               1 | Foundation | Bed Frames |

  Scenario Outline: 11 Verify Inline Error message for Invalid format of Last name
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to enter Contact details <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to enter Firstname and Lastname <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to click on complete order button
    Then user should able to view the error message for invalid "lastname" field as <Validation code>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | ErrorMessage |

    Examples: 
      | Iteration | Validation code | Product1   | Category   |
      |        10 |               2 | Foundation | Bed Frames |

  @REP-3903 
  Scenario Outline: 12 Verify the promotions email checkbox is displayed below contac details
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to view the promotions email checkbox
    Then user should able to view the copytext of checkbox as "Sign up to get insider access to Purple tech, deals, product releases, and more!"

    Examples: 
      | Product1   | Category   |
      | Foundation | Bed Frames |
