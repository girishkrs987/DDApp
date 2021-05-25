@Sprint11Feedbacks @purple11 @sprint11
Feature: AOV section

  Background: 
    #Given User Launches the browser
    Given User Launches the browser for pdp pages

  #And User navigates to the Purple site
  
  @REP-4029 @sprint11 
  Scenario Outline: Verify the user should able to remove the gift product from the cart
     #	Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on keep shopping button
    #Then user should able to add the product "<Product2>" from "<Category>"
    #Then user should able to click on view cart button
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click edit link of "<Product1>"
    Then user should able to select the size as "<Size>"
    Then User clicks on update button
    Then user able to view the Size "<Size>" is updated in cart page for "<Product1>"
    Then user should able to click edit link of "<Product2>"
    Then user should able to select the size as "King/Cal King"
    Then User clicks on update button
    Then user able to view the Size "<Size>" is updated in cart page for "<Product2>"
    Then user should able to view the promo lable for freegift
    Then user should remove the product from the cart to make it empty
    

    Examples: 
      | Iteration | Product1            | Product2          | Size |
      |         1 | The Purple Mattress | The Purple Sheets | King |

@REP-5028 
  Scenario Outline: Verify that AOV bundle shown for the product with highest price without discount
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
     Then user should able to land on Cart page
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
      Then user should able to view the Billing address checkbox

    Examples: 
      | Iteration | Product1            | Product2               | Category   |
      |         1 | The Purple Mattress | Purple Hybrid Mattress | Mattresses |

  

  Scenario Outline: Verify the CVV info popup title as "SECURITY CODE/CVV"
   Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
     Then user should able to land on Cart page
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
      Then user should able to click on CVV info icon
     Then user should able to view CVV info popup title as "Security Code/CVV"

    Examples: 
      | Iteration | Product1            | Product2               | Category   |
      |         1 | The Purple Mattress | Purple Hybrid Mattress | Mattresses |
      
