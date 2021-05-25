@CartOrderSummary @purple1
Feature: Order Summary in Cart page

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-807
  Scenario Outline: 1 Ability of the user to view the order summary section
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should be able to view "Order Summary" section in cart page
    And User should able to view the line item which indicates the total number of products added to cart "Items ( x"
    Then User should able to view the total cost of the product
    Then user should able to click "Add Promo Code" link
    And user should be able to enter a promocode in the field as <PromoCode>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | Promocodes |
    And the offer should be applied Successfully
    Then User should able to view the line item with details on the promo code applied, the discounted cost should be shown as a negative value
    And User should able to view a highlighted box with the total savings value  "You’re saving"
    Then user should be able to view "Subtotal" section in cart page
    Then user should be able to view the subtotal value
    And User should able to view the EMI Per month value
    Then User should able to view the Prequalify link
    When User click on Prequalify link
    Then user closed the Affirm pop up
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page

    Examples: 
      | PromoCode | Product1        | Product2                       | Category   |
      |         1 | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 2 Ability of the user not to view the promo code line item, when it is not applied
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should be able to view "Order Summary" section in cart page
    And User should able to view the line item which indicates the total number of products added to cart "Items ( x"
    Then User should able to view the total cost of the product
    And The promo code line item should not be displayed

    Examples: 
      | Product1       | Product2      | Category |
      | Purple Harmony | Purple Pillow | Pillows  |

  Scenario Outline: 3 Ability of the user to view a note below the “Estimated shipping & Taxes” line item - "You've qualified for FREE whiteglove shipping!" if applicable
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should be able to view "Order Summary" section in cart page
    And User should able to view the line item which indicates the total number of products added to cart "Items ( x"
    Then User should able to view a note below the Estimated shipping & Taxes line item "* You've qualified for FREE shipping!" if applicable

    Examples: 
      | Product1   | Product2  | Category   |
      | Foundation | PowerBase | Bed Frames |
