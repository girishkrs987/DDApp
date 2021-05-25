@sprint12
Feature: Cart Page and AOV - Enhancement

  Background: 
    #Temp product page
    Given User Launches the browser for pdp pages
    
    #Purple Home page
    #And User navigates to the Purple site

  @REP-5080 @sprint12
  Scenario Outline: To verify copy text change from Prequalify Now to Prequalify Now with Affirm in cart page.
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then User should able to view the Prequalify link
    Then Verify the text name is "Prequalify Now with Affirm"

    Examples: 
      | Iteration | Product1                      |
      |         1 | Sleepy Jones + Purple Pajamas |

  @REP-5080 @sprint12
  Scenario Outline: To verify cart is empty if user decreases the count to Zero
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user shoud able to Increase the product quantity as "0" for "<Product1>"
    Then user should remove the product from the cart to make it empty

    Examples: 
      | Iteration | Product1                      |
      |         1 | Sleepy Jones + Purple Pajamas |

  @REP-5126 @sprint12
  Scenario Outline: To verify strikethrough price and promo label in AOV section
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user should able to view the AOV section
    Then user able to verify strikethrough price in AOV section
    And user able to verify promo label in AOV section
    And user should be able to add the products from AOV section
    Then user able to verify strikethrough price in product section
    And user able to verify promo label in product section

    Examples: 
      | Iteration | Product1            |
      |         1 | The Purple Mattress |

  @REP-5089 @sprint12
  Scenario Outline: To verify copy text change from Prequalify Now to Prequalify Now with Affirm in cart page.
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then User should able to view the Prequalify link
    Then Verify the text name is "Prequalify Now with Affirm"

    Examples: 
      | Iteration | Product1                      |
      |         1 | Sleepy Jones + Purple Pajamas |

  @REP-5367 @sprint12
  Scenario Outline: To verify cart icon persistent with or without items
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user shoud able to Increase the product quantity as "0" for "<Product1>"
    Then user able to verify the cart icon persistent

    Examples: 
      | Iteration | Product1                      |
      |         1 | Sleepy Jones + Purple Pajamas |

  @REP-5368 @sprint12
  Scenario Outline: To verify free items in cart increase decrease functionality in cart
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user should able to select the size as "<Size>"
    Then User clicks on update button
    Then user should able to click edit link of "<Product2>"
    Then user should able to select the size as "<Size2>"
    Then User clicks on update button
    Then user verify free product is displayed
    Then user shoud able to Increase the product quantity as "2" for "<Product2>"
    Then user able to see new line item added to the cart
    Then user shoud able to Increase the product quantity as "1" for "<Product2>"
    Then user able to see new line item removed to the cart

    Examples: 
      | Iteration | Product1            | Product2          | Size | Size2         |
      |         1 | The Purple Mattress | The Purple Sheets | King | King/Cal King |

  @REP-5369 @sprint12
  Scenario Outline: To verify free items in cart increase decrease functionality in cart
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user should able to select the size as "<Size>"
    Then User clicks on update button
    Then verify promo label is displayed for the product
    And verify promo label is displayed for AOV product

    Examples: 
      | Iteration | Product1            | Product2          | Size    |
      |         1 | The Purple Mattress | The Purple Sheets | Twin XL |
