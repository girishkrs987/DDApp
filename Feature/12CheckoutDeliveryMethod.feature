@ShippingMethod @purple1
Feature: Shipping Method

  Background: 
    #Given User Launches the browser
    #And User navigates to the Purple site
    Given User Launches the browser for pdp pages

  @REP-673
  Scenario Outline: 1 Verify user able to view the title of the section (Delivery Method)
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then User should able to to view the title of the page as "Checkout"
    Then user should be able to view "Delivery Method" section in checkout page
    Then User should able to view the title of the "Larger Items" group
    Then User should able to view the title of the "Smaller Items" group
    Then user should be able to view default delivery methods as "Standard Ground Shipping" for large items
    Then user should be able to view default delivery methods as "Standard Ground Shipping" for small items

    Examples: 
      | Iteration | Product1        | Product2               | Category   |
      |         1 | Purple Mattress | Purple Hybrid Mattress | Mattresses |

  # Items grouped into Larger & Smaller items when the address is non AK & HI
  Scenario Outline: 2 Verify user able to view the products grouped into Larger & Smaller items when the address is non AK & HI
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
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
    #Then User should able to see a loading indicator with message "Updating delivery options"
    Then User should able to view the title of the "Larger Items" group
    Then User should able to view the title of the "Smaller Items" group
    Then User should able to view the thumbnail image of "<Product1>"
    Then User should able to view the thumbnail image of "<Product2>"
    And user able to view the "<Product1>" name with variant size and color
    And user able to view the "<Product2>" name with variant size and color
    Then User should able to view shipping method below larger itmes group
    Then User should able to view shipping method below smaller itmes group
    And user able to view shipping cost beside each delivery method or "Free" text if it is free

    Examples: 
      | Iteration | Product1               | Product2                       | Category   |
      |         1 | Purple Hybrid Mattress | Purple Hybrid Premier Mattress | Mattresses |

  # Purple Hybrid Premier Mattress & The Purple Mattress should be grouped under Larger items grouping
  Scenario Outline: 3 Verify user able to view information icon near the Larger items section title
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
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
    Then User should able to view the title of the "Larger Items" group
    Then User should able to view the title of the "Smaller Items" group
    Then User should able to view information icon near the larger items section title
    When User clicks on the larger item information icon
    Then user able to view the info popup
    And The pop up should have title as "Larger Items"
    And user should able to view the popup information content
    When user clicks on the Close button

    # Then popup should get closed
    Examples: 
      | Iteration | Product1        | Product2               | Category   |
      |         1 | Purple Mattress | Purple Hybrid Mattress | Mattresses |

  ##### this scenario is removed since any one of the delivery method will be selected by default #####
  #Scenario Outline: 4 Verify user able to view a error message without selecting any delivery method and Complete Order button is clicked
  #Then user should able to add the product "<Product1>" from "<Category>"
  #Then user should able to click on keep shopping button
  #Then user should able to add the product "<Product2>" from "<Category>"
  #Then user should able to click on view cart button
  #Then user should able to land on Cart page
  #Then User should able to to view the title of the page as "Cart"
  #Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
  #Then user should able to click on Checkout button
  #Then user should able to land on Checkout page
  #Then user should able to enter Contact details <Iteration>
  #| InputFileName    | SheetName    |
  #| Purple_DataSheet | DeliveryInfo |
  #Then user should able to enter Firstname and Lastname <Iteration>
  #| InputFileName    | SheetName    |
  #| Purple_DataSheet | DeliveryInfo |
  #Then user should able to enter Address <Iteration>
  #| InputFileName    | SheetName    |
  #| Purple_DataSheet | DeliveryInfo |
  #Then user should able to enter City state and zipcode <Iteration>
  #| InputFileName    | SheetName    |
  #| Purple_DataSheet | DeliveryInfo |
  # Then User should able to see a loading indicator with message "Updating delivery options"
  #Then user should able to select the payment method as "<Payment Method>"
  #Then user should be able to click on complete order button
  #Then The error message should get displayed below Delivery method title as "Please select a delivery method"
  #Then user should be able to select the relevant shipping method
  #Then User should be able to view a error message should be removed
  #
  #Examples:
  #| Iteration | Product1   | Product2  | Category   | Payment Method |
  #|         1 | Foundation | PowerBase | Bed Frames | splitit        |
  #SPECIFIC COVID-19 SITUATION SCENARIOS - @REP-2778
  # Error message - When larger items(ship-weight>=150lbs) are added in the order and delivery info has the state selected as Alaska or Hawaii
  #Scenario Outline: 6 Verify All the products which has weight < 150 lbs  to have Standard Ground Shipping option only
  # Scenario Outline: 7 Verify All the products which has weight > 150 lbs  to have Standard Ground Shipping and Scheduled Delivery - " Powerbase"
  Scenario Outline: 5 Verify user able to view a error message, where user has added larger items(ship-weight>=150lbs) in cart, then the state selected is AK/HI
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
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
    Then User should able to see a loading indicator with message "Updating delivery options"
    Then error message should get displayed below Delivery method title as "Your cart has been updated and the items you added can't be shipped to your address. Remove the items to complete your order."
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then User should able to view the close button against each product for "<Product2>"
    When clicking on close button against "<Product2>"
    Then It should remove the "<Product2>" from the list
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should see the error message is removed

    Examples: 
      | Iteration | Product1   | Product2  | Category   |
      |         6 | Foundation | PowerBase | Bed Frames |

  @REP-2778
  Scenario Outline: 6 Verify Hybrid premier mattress and Purple hybrid mattress split king variant should have shipping method same as (ship-weight<150lbs) product Since it will be shipped with 2 packages
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then User should able to view the list of products added to cart "<Product1>" and "<Product2>"
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
    Then user should be able to view default delivery methods as "Standard Ground Shipping" for large items

    Examples: 
      | Iteration | Product1                       | Product2               | Category   |
      |         6 | Purple Hybrid Premier Mattress | Purple Hybrid Mattress | Mattresses |

  Scenario Outline: 7 verify Hybrid premier mattress even if it is >150 lbs should able ship to AK/HI as 2 packages as Smaller items
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click edit link of "<Product1>"
    Then user should able to select the size as "<Size>"
    Then User clicks on update button
    Then user able to view the Size "<Size>" is updated in cart page for "<Product1>"
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
    Then User should able to see a loading indicator with message "Updating delivery options"
    Then User should able to view the title of the "Smaller Items" group
    Then user able to view the shipping method rendered from fedex

    Examples: 
      | Iteration | Product1                       | Category   | Size       |
      |         6 | Purple Hybrid Premier Mattress | Mattresses | Split King |

  Scenario Outline: 8 verify Hybrid mattress even if it is >150 lbs should able ship to AK/HI as 2 packages as Smaller items
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then User should able to to view the title of the page as "Cart"
    Then user should able to click edit link of "<Product1>"
    Then user should able to select the size as "<Size>"
    Then User clicks on update button
    Then user able to view the Size "<Size>" is updated in cart page for "<Product1>"
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
    Then User should able to see a loading indicator with message "Updating delivery options"
    Then user able to view the shipping method rendered from fedex

    Examples: 
      | Iteration | Product1               | Category   | Size       |
      |         6 | Purple Hybrid Mattress | Mattresses | Split King |

  @REP-4416  @purple11 @spirnt9
  Scenario Outline: 9 Verify user should able to view only standard shipping options for small items
    #Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on view cart button
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
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
    Then User should able to view the title of the "Standard Shipping Only" group
    Then user should be able to view default delivery methods as "Standard Shipping" for small items

    Examples: 
      | Iteration | Product1          | Product2               | Category   |
      |         1 | Kid Purple Mattress | Purple Hybrid Mattress | Mattresses |

   @REP-4416  @purple11 @spirnt9
  Scenario Outline: 9 Verify user should able to view Free in homes steup option for Purple Hybrid Premier Mattresses
    #Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on view cart button
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
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
    Then User should able to view the title of the "In-Home Setup Qualified TEST" group
    Then user should be able to view delivery methods as "In-Home Setup" for Purple Hybrid Premier Mattresses
    Then user should be able to view delivery methods as "Standard Shipping TEST" for Purple Hybrid Mattress

    Examples: 
      | Iteration | Product1                       | Product2               | Category   |
      |         1 | Purple Hybrid Premier Mattress | Purple Hybrid Mattress | Mattresses |
      
       @REP-4416 @purple11 @spirnt9
  Scenario Outline: 9 Verify user should able to view Paid inHome setup for Purple Mattress
    #Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on view cart button
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
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
    Then User should able to view the title of the "In-Home Setup Qualified TEST" group
    Then user should be able to view delivery methods as "In-Home Setup" for Purple Hybrid Premier Mattresses
    Then user should able to view paid inhome Setup option for "$200"

    Examples: 
      | Iteration | Product1                       | Product2               | Category   |
      |         1 | The Purple Mattress | Purple Hybrid Mattress | Mattresses |
