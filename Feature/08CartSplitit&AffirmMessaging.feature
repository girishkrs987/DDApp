@Affirm&Splitit @purple1
Feature: Splitit and Affirm section in cart page

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site
    
    @REP-3472
  Scenario Outline: 1 Verify user able to view the Affirm and split it section in cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to view splitit and affirm section in Cart page
    Then user should able to view the affirm splitit section title as "Looking to Finance?"
    Then user should able to view the affirm splitit section description as "Select one of these at Checkout"

    Examples: 
      | Iteration | Product1 | Product2         | Category | Pay Account |
      |         1 | Duvet    | Weighted Blanket | Bedding  | Amazon      |

  Scenario Outline: 2 Verify user able to view splitit logo description and Popup
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to view splitit and affirm section in Cart page
    Then user should able to view splitit logo and short description as "Monthly payments using your credit card at 0% interest."
    Then user should able to view "Learn More" link of splitit
    When user click on "Learn More" link of splitit
    Then user should able to view Splitit popup
    Then user should able to close the splitit popup
    Then user should able to land on Cart page

    Examples: 
      | Iteration | Product1 | Product2         | Category | Pay Account |
      |         1 | Duvet    | Weighted Blanket | Bedding  | Amazon      |

  Scenario Outline: 3 Verify user able to view Affirm logo description and Popup
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to view splitit and affirm section in Cart page
    Then user should able to view affirm logo and short description as "Monthly Payments with as low as 0% APR financing."
    Then user should able to view "Learn More" link of affirm
    When user click on "Learn More" link of affirm
    When user click on "Learn More" link of affirm
    Then user should able to view affirm popup
    Then user should able to close the affirm popup
    Then user should able to land on Cart page

    Examples: 
      | Iteration | Product1       | Product2      | Category | Pay Account |
      |         1 | Purple Harmony | Purple Pillow | Pillows  | Amazon      |

  Scenario Outline: 4 Verify user able to view Affirm and splitit section in empty cart
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to view splitit and affirm section in Cart page
    Then user should able to view splitit logo and short description as "Monthly payments using your credit card at 0% interest."
    Then user should able to view "Learn More" link of splitit
    When user click on "Learn More" link of splitit
    Then user should able to view Splitit popup
    Then user should able to close the splitit popup
    Then user should able to view affirm logo and short description as "Monthly Payments with as low as 0% APR financing."
    Then user should able to view "Learn More" link of affirm
    When user click on "Learn More" link of affirm
    Then user should able to view affirm popup
    Then user should able to close the affirm popup
    Then user should able to land on Cart page

    Examples: 
      | Iteration | Product1 | Product2         | Category | Pay Account |
      |         1 | Duvet    | Weighted Blanket | Bedding  | Amazon      |
