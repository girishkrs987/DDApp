@VariantPopup @purple1
Feature: Variant Popup

  Background: 
    Given User Launches the browser
    And User navigates to the Purple site

  @REP-1622 
  Scenario Outline: 1 Verify the Edit link against Each product
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to view edit link of "<Product1>"
    Then user should able to view edit link of "<Product2>"

    Examples: 
      | Iteration | Product1   | Product2  | Category   |
      |         1 | Foundation | PowerBase | Bed Frames |

  Scenario Outline: 2 Verify the Edit link is not displayed if the product has no variant
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then The edit link should not be displayed to "<Product1>"
       | Iteration | Product1 | Product2         | Category |
      |         3 | Weighted Blanket    | Duvet | Bedding  |

  
  Scenario Outline: 3 Verify the Components of Variant Popup
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user shoud able to view the varaint popup for "<Product1>"
    Then user should able to view Popup title as "Update"
    Then user should able to view "<Product1>" name
    Then user should able to view "View Product Details" link
    Then user should able to view product image
    Then user should able to view Size dropdown
    Then user should able to view colour selection
    Then user should able to view product price
    Then user should able to view Update button
    Then user should able to view Close popup button

    Examples: 
      | Iteration | Product1                  | Category |
      |         1 | Purple SoftStretch Sheets | Bedding  |

  Scenario Outline: 4 Verify the Selected variant is updated in the cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user shoud able to view the varaint popup for "<Product1>"
    Then user should able to view Popup title as "Update"
    Then user should able to view "<Product1>" name
    Then user should able to select the size as "<Size>"
    Then User clicks on update button
    Then user able to view the Size "<Size>" is updated in cart page for "<Product1>"

    Examples: 
      | Iteration | Product1   | Category   | Size  |
      |         1 | Foundation | Bed Frames | Queen |

  Scenario Outline: 5 Verify the Selected Color is updated in the cart page
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user shoud able to view the varaint popup for "<Product1>"
    Then user should able to view Popup title as "Update"
    Then user should able to view "<Product1>" name
    Then user should able to select the colour as "<Color>"
    Then User clicks on update button
    Then user able to view the Size "<Color>" is updated in cart page for "<Product1>"

    Examples: 
      | Iteration | Product1   | Category   | Color         |
      |         1 | Foundation | Bed Frames | Charcoal Grey |

  Scenario Outline: 6 Verify the Close button should close the Popup
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user shoud able to view the varaint popup for "<Product1>"
    Then close the popup for "<Product1>"
    Then user should able to click edit link of "<Product2>"
    Then user shoud able to view the varaint popup for "<Product2>"
    Then close the popup for "<Product2>"
   
   

    Examples: 
      | Iteration | Product1               | Product2        | Category   |
      |         1 | Purple Hybrid Mattress | Purple Mattress | Mattresses |
