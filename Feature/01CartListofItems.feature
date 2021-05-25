@ListofItemInCart @purple1
Feature: List of items in the Cart

  Background: 
    #Given User Launches the browser
    #And User navigates to the Purple site
    
    Given User Launches the browser for pdp pages

  @REP-634
  Scenario Outline: 1 Ability of the user to view the List of Items in cart page
  Then user should able to add the product "<Product1>"
    #Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>"
    #Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then User should able to view the count of the number of products available in cart
    Then user shoud able to Increase the product quantity as "2" for "<Product1>"
    Then The product count should get updated to actuals plus "1"
    And user able to view the product variant and Color for "<Product1>"

    Examples: 
      | Iteration | Product1       | Product2      | Category |
      |         1 | The Purple Harmony Pillow | The Purple Pillow | Pillows  |

  Scenario Outline: 2 Ability of the user to view the free gifts products grouped in a section with the title Free gifts with product category in cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then User should able to view the free gifts products grouped in a section with the title "Free Gifts with Mattresses" product category
    And User should able to view the quantity field in the free gifts products group
    Then user shoud able to Increase the product quantity as "3" for "<Product2>"
    And The quantity should increase or decrease based on the parent product quantity "<Product2>"
    And User should able to view the strikethrough price of the free products and also the "Free" text
    And User should able to view the "Add another for $" link below each free product
    When clicking on "Add another for $" link below each free product
    Then user should able to view another product added to cart
    When clicking on close button against "<Product2>"
    Then The free product should also automatically get removed from cart

    Examples: 
      | Iteration | Product1               | Product2                       | Category   |
      |         1 | Purple Hybrid Mattress | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 3 Ability of the user to view the close button against each product in cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then User should able to view the count of the number of products available in cart
    Then User should able to view the close button against each product for "<Product2>"
    When clicking on close button against "<Product2>"
    Then It should remove the "<Product2>" from the list

    Examples: 
      | Iteration | Product1   | Product2  | Category   |
      |         1 | Foundation | PowerBase | Bed Frames |

  Scenario Outline: 4 Ability of the user to view the Empty cart if all the product is removed
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to view the close button against each product for "<Product1>"
    When clicking on close button against "<Product1>"
    Then user should remove the product from the cart to make it empty
    Then user should able to view the cart is empty

    # And User should able to view the product name, starting at price, image along with learn more button
    #  And User should able to click on the “Learn More” button to get navigated to the Mattresses category List page
    Examples: 
      | Iteration | Product1        | Category   |
      |         1 | Purple Mattress | Mattresses |

  Scenario Outline: 5 Ability of the user to view the Error message when user tries to place order more that 50 items
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user shoud able to Increase the product quantity as "12" for "<Product1>"
    Then user should able to click on Checkout button
    Then user should able to view error message for ordering more than 50 Qty
    Then the error message should read as "Call us at 1-888-848-0248 to complete your order, or remove(x) items form your cart"

    Examples: 
      | Iteration | Product1                       | Category   |
      |         1 | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 6 Verify the error message gets disappear when user reduces the quantity to less than 50
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user shoud able to Increase the product quantity as "12" for "<Product1>"
    Then user should able to click on Checkout button
    Then user should able to view error message for ordering more than 50 Qty
    When clicking on close button against "<Product1>"
    Then user should able to view the error message gets disappear

    Examples: 
      | Iteration | Product1                       | Product2        | Category   |
      |         1 | Purple Hybrid Premier Mattress | Purple Mattress | Mattresses |
