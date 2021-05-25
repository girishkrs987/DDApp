@PromoLabel&FreeProducts @purple1 @sprint9
Feature: PromoLabel&FreeProducts

  Background: 
    #Given User Launches the browser
    Given User Launches the browser for pdp pages

  #And User navigates to the Purple site
  @REP-4532
  Scenario Outline: 1 Verify the Promo Label in the cart page
    Then user should able to add the product "<Product1>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product1>"
    Then user shoud able to view the varaint popup for "<Product1>"
    Then user should able to view Popup title as "Update"
    Then user should able to view "<Product1>" name
    Then user should able to select the size as "King"
    Then User clicks on update button
    Then user able to view the Size "King" is updated in cart page for "<Product1>"
    Then user should able to add the product "<Product2>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click edit link of "<Product2>"
    Then user shoud able to view the varaint popup for "<Product2>"
    Then user should able to view Popup title as "Update"
    Then user should able to view "<Product2>" name
    Then user should able to select the size as "King/Cal King"
    Then User clicks on update button
    Then user able to view the Size "King/Cal King" is updated in cart page for "<Product2>"
    Then user shoud able to view the promo label above the product title
    Then user shoud able to view a tag icon in the promo labels

    Examples: 
      | Iteration | Product1            | Product2                  |
      |         1 | The Purple Mattress | Purple SoftStretch Sheets |

@purple11
  Scenario Outline: 2 Verify the Free Products in the cart page
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
    Then user shoud able to view a gift icon in the promo labels shown for Free Products
    Then The edit link should not be displayed to "<Product2>"

    ################ the below line are not applicable, it has been enhanced as per latest update #############
    #Then user shoud able to view the free product line item should not have the remove button
    #Then user shoud able to view the quantity button should show up in a blurred state
    #And User should able to view the "Add another for $" link below each free product
    #When clicking on "Add another for $" link below each free product
    #Then user should able to view another product added to cart
    Examples: 
      | Iteration | Product1            | Product2          | Size |
      |         1 | The Purple Mattress | The Purple Sheets | King |
@purple11
  Scenario Outline: 3 Verify the Free Products in the checkout page
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
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout Test"
    Then user should be able to view "Cart Summary" section in checkout page
    Then User should able to view the list of products added in Cart Summary of checkout page "<Product1>" and "<Product2>"

    Examples: 
      | Iteration | Product1            | Product2          | Size |
      |         1 | The Purple Mattress | The Purple Sheets | King |

  @purple11
  Scenario Outline: 4 Verify the Free Products in the Order Confirmation page
    #		Then user should able to add the product "<Product1>" from "<Category>"
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
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout Test"
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
    Then user should be able to select the relevant shipping method
    Then user should able to select the payment method as "<Payment Method>"
    Then user should be able to click on complete order button
     Then user completes the Affirm payment process <Iteration>
      | InputFileName    | SheetName      |
      | Purple_DataSheet | PaymentDetails |
    Then user should be navigated to the Order Confirmation page with title as "Order Confirmation Test"
    Then user should be able to view the same products added to cart "<Product1>"
    Then user should be able to view the same products added to cart "<Product2>"

    #Then user shoud able to view that clubbing of the free gift with the main product is not applicable in the Order Confirmation page
    Examples: 
      | Iteration | Product1            | Product2          | Size | Payment Method |
      |         1 | The Purple Mattress | The Purple Sheets | King | affirm        |
