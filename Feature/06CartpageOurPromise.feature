@OurPromise @purple1
Feature: Our Promise and Support/Chat section in Cart page

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-1291 @REP-2558
  Scenario Outline: 1 Verify Our promise section is displayed in Cart page with respective icons
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to view Our Promise Section
    Then user should able to view "Our Promise" title
    And user should able view "10-Year Warranty" icon in Our Promise Section
    #And user should able view " 10-Year Warranty" text below the icon
    And user should able view "Flexible Financing Options" icon in Our Promise Section
    And user should able view "Free Shipping & Returns" icon in Our Promise Section
    
    And user should able view "100-Night Trial" icon in Our Promise Section
    Examples: 
      | Iteration | Product1         | Category |
      |         1 | Weighted Blanket | Bedding  |

  Scenario Outline: 2 Verify Our Support/Chat is displayed in Cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to view Chat with a service agent link
    Then user should able to view Chat with a service agent icon
    Then user should able to view Customer service icon
    Then user should able to view Customer service number link
    Then user clicks on Customer service number link
    Examples: 
      | Iteration | Product1   | Category   |
      |         1 | Foundation | Bed Frames |

  
  Scenario Outline: 3 Verify user able to view promises for various product category and additional promises
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to view Our Promise Section
    Then user should able to view "Our Promise" title
    Then user able to view " 10-Year Warranty" for "Mattresses"
    Then user able to view " 1-Year Warranty" for "Pillows, Cushions, Pet Beds"
    Then user able to view " 100-Night Trial" for "Mattresses, Cushions, Pet Beds"
    Then user able to view " 30-Day Trial" for "Seat Cushions"
    Then user able to view " Flexible Financing Options" and description as "As low as 0% APR"
    Then user able to view " Free Shipping & Returns" and description as "In the Contiguous States"
    Examples: 
      | Iteration | Product1               | Category   |
      |         1 | Purple Hybrid Mattress | Mattresses |
