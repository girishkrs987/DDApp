@CheckoutCartSummary @purple1
Feature: Cart Summary in Checkout page

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-166 
  Scenario Outline: 1 Ability of the user to view the cart summary section
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to view the count of the number of products available in cart
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view "Cart Summary" section in checkout page
    Then User should able to view the list of products added in Cart Summary of checkout page "<Product1>" and "<Product2>"
    Then User should able to view the count of the number of products in checkout page cart Summary
    And variant and Color is displayed for "<Product1>"
    And actual price is displayed for "<Product1>"
    And variant and Color is displayed for "<Product2>"
    And strikethrough price is displayed for "<Product2>"
    And actual price is displayed for "<Product2>"

    Examples: 
      | Iteration | Product1          | Product2       | Category |
      |         1 | Kid Purple Pillow | Purple Harmony | Pillows  |

  Scenario Outline: 2 Ability of the user to view the free gifts products in cart summary section with the title Free gifts with product category in checkout page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should be able to view "Cart Summary" section in checkout page
    Then User should able to view the list of products added in Cart Summary of checkout page "<Product1>" and "<Product2>"
    Then User should able to view the free gifts for "<Product1>" with section title as "Free Gifts with Mattresses"
    Then User should able to view the free gifts for "<Product2>" with section title as "Free Gifts with Mattresses"
    And User should able to view the strikethrough price of the gift product of "<Product1>"
    And User should able to view the "Free" text for the gift product of "<Product1>"
    And User should able to view the strikethrough price of the gift product of "<Product2>"
    And User should able to view the "Free" text for the gift product of "<Product2>"

    Examples: 
      | Iteration | Product1        | Product2               | Category   |
      |         1 | Purple Mattress | Purple Hybrid Mattress | Mattresses |

  Scenario Outline: 3 Ability of the user to view the order summary section with promo code details
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view "Order Summary" section in checkout page
    And User should able to view the line item which indicates the total number of products "Items ( x"
    Then User should able to view the total cost of the product
    Then user should able to click "Add Promo Code" link
    And user should be able to enter a promocode in the field as <PromoCode>
      | InputFileName    | SheetName  |
      | Purple_DataSheet | Promocodes |
    Then user should be able to click on apply button
    And the offer should be applied Successfully
    Then User should able to view the line item with details on the promo code applied, the discounted cost should be shown as a negative value
    #Then user should be able to view the line item which indicates the Taxes value
    And User should able to view a highlighted box with the total savings value  "You’re saving"
    Then user should be able to view " Subtotal" section in checkout page
    Then user should be able to view the subtotal value

    Examples: 
      | PromoCode | Product1        | Product2                       | Category   |
      |         1 | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 4 Ability of the user not to view the promo code line item, when it is not applied
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should be able to view "Order Summary" section in checkout page
    And User should able to view the line item which indicates the total number of products "Items ( x"
    Then User should able to view the total cost of the product
    And The promo code line item should not be displayed

    Examples: 
      | Iteration | Product1         | Product2 | Category |
      |         1 | Weighted Blanket | Duvet    | Bedding  |

  Scenario Outline: 5 Ability of the user to view the line item for shipping cost or Shipping Cost. In case if there is no shipping cost, then instead of cost “Free” text is shown
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should be able to view "Order Summary" section in checkout page
    And User should able to view the line item which indicates the total number of products "Items ( x"
    And User should able to view Shipping cost line item, if there is no shipping cost, then instead of cost "Free" text is shown

    Examples: 
      | Iteration | Product1   | Product2  | Category   |
      |         1 | Foundation | PowerBase | Bed Frames |

  Scenario Outline: 6 Ability of the user to view a note below the shipping line item - "* You've qualified for FREE shipping!" if applicable
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then User should able to view the list of products added in Cart Summary of checkout page "<Product1>" and "<Product2>"
    Then user should be able to view "Order Summary" section in checkout page
    And User should able to view the line item which indicates the total number of products "Items ( x"
    Then User should able to view a note below the Estimated shipping line item " * You've qualified for FREE shipping!"

    Examples: 
      | Iteration | Product1                  | Product2      | Category |
      |         1 | Purple SoftStretch Sheets | Purple Sheets | Bedding  |

  #	""" Recycling Fee not part of REP-166 and REP-3479 User Story"""
  @REP-3479
  Scenario Outline: 7,8,9 Ability of the user to view the line item for "Recycling fee" below Taxes for states CT,CA and RI
    Then user should able to add the product "<Product1>" from "<Category>"
    # Then user should able to click on keep shopping button
    # Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to view "Order Summary" section in checkout page
    And User should able to view the line item which indicates the total number of products "Items ( x"
    And user should able to view the "Recycling fee" line item in order summary
    Then user should able to view the recycling fee cost

    #And User should able to view the line item which indicates the "Recycling fee" below Taxes for applicable states, when user opts for Old mattress removal option
    Examples: 
      | Iteration | Product1        | Product2                       | Category   |
      | CT        | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |
      | CA        | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |
      | RI        | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 10 Ability of the user verify the recycling fee is applied to every mattress in the cart
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    And user should able to view the "Recycling fee" line item in order summary
    Then user should able to view the recycling fee cost
    When user click on Cart Icon
    Then user shoud able to Increase the product quantity as "2" for "<Product1>"
    Then user shoud able to Increase the product quantity as "2" for "<Product2>"
    Then user should able to click on Checkout button
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should able to view the recycling fee is added every mattress

    Examples: 
      | Iteration | Product1        | Product2                       | Category   |
      | CT        | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |
