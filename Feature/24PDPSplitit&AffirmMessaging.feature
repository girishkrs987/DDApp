@PDP-Affirm&Splitit @purple1
Feature: Splitit and Affirm section in Product detail page page

  Background: 
    Given User Launches the browser for pdp pages

  @REP-3472 
  Scenario Outline: 1 Verify user able to view the Affirm and split it section in product detail page
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view splitit and affirm section in product detail page
    Then user should able to view the affirm value is fetched with "PAY AS LOW AS" text
    And the user should able to view "PAY ONCE" value
    Then user should able to view the Vertical line in between

    Examples: 
      | Iteration | Product1                       |
      |         1 | Purple Hybrid Premier Mattress |

  Scenario Outline: 2 Verify user able to view only the Pay now component if cart value is <$100
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    And the user should able to view "PAY ONCE" value
    And the Affirm and splitit section should not be displayed for the cart value < 100

    Examples: 
      | Iteration | Product1           | 
      |         1 | Premium Sleep Mask |  
      
     
  Scenario Outline: 3 Verify user able to view splitit logo description and Popup
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view splitit and affirm section in product detail page
    Then user should able to view splitit logo and description as "Monthly payments using your credit card at 0% interest."
    Then user should able to view "Learn More" link for splitit
    When user click on "Learn More" link for splitit
    Then user should able to view Splitit popup
    Then user should able to close the splitit popup
    Then user should able to land on PDP page

    Examples: 
      | Iteration | Product1                       |
      |         1 | Purple Hybrid Premier Mattress |

  Scenario Outline: 4 Verify user able to view Affirm logo description and Popup
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view splitit and affirm section in product detail page
    Then user should able to view affirm logo and description as "Monthly payments as low as 0% APR financing."
    Then user should able to view "Learn More" link for affirm
    When user click on "Learn More" link for affirm
    Then user should able to view affirm popup
    Then user should able to close the affirm popup
    Then user should able to land on PDP page

    Examples: 
      | Iteration | Product1                       | Product2      | Category | Pay Account |
      |         1 | Purple Hybrid Premier Mattress | Purple Pillow | Pillows  | Amazon      |
