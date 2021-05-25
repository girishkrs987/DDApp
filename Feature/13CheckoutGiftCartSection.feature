@GiftCard @purple1
Feature: Egifter Validations

  Background:
  Given User Launches the browser for pdp pages 
    #Given User Launches the browser 
    And User navigates to the Purple site

  Scenario Outline: 1 Verify the UI of the gift card
    Then user should able to add the product "<Product2>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view " Payment Info" section in checkout page
    Then user should able to click "Add Gift Card" link
    And user shoud able to view note next to title as "(All transactions are secure and encrypted)"
    And user should able to view the gift cart text field under the payment info title
    And user should able to view the place holder text as "Gift Card Number"
    And user should able to view the apply button
    And user should able to view information below text field as "You can apply up to 4 gift cards"

    Examples: 
      | Iteration | Product1        | Product2                       | Category   |
      |         1 | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |

  Scenario Outline: 2 Verify the user can able to apply gift card and the details of gift card added below the payment info title
    Then user should able to add the product "<Product2>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view " Payment Info" section in checkout page
    Then user should able to click "Add Gift Card" link
    And user should able to view the gift cart text field under the payment info title
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the gift card details below payment info section
    And user should able to view the remove button againt each gift card
    And user should able to view the gift cart balance text as "Amount on card"
    And user should able to view the balance amount of the gift card

    Examples: 
      | GiftCard | Product1          | Product2       | Category |
      |        1 | Kid Purple Pillow | Purple Hybrid Premier Mattress | Pillows  |

  Scenario Outline: 3 Verify the ability of the user to click on the close button in the gift card details section to remove it
    Then user should able to add the product "<Product1>" from "<Category>"
    Then user should able to click on keep shopping button
    Then user should able to add the product "<Product2>" from "<Category>"
    Then user should able to click on view cart button
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should be able to view " Payment Info" section in checkout page
    Then user should able to click "Add Gift Card" link
    And user should able to view the gift cart text field under the payment info title
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the gift card details below payment info section
    And user should able to view the remove button againt each gift card
    And user should able to click on remove button
    Then user should able to view the applied gift card is removed

    Examples: 
      | GiftCard | Product1        | Product2                       | Category   |
      |        1 | Purple Mattress | Purple Hybrid Premier Mattress | Mattresses |
@purple1
  Scenario Outline: 4 Verify the Error message if the gift card application reaches to maximum of 4
   Then user should able to add the product "<Product2>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should be able to view " Payment Info" section in checkout page
    Then user should able to click "Add Gift Card" link
    And user should able to view the gift cart text field under the payment info title
    Then user should able to enter the giftcard number and click on apply for four times <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the error message as "You can only use 4 gift cards"

    Examples: 
      | GiftCard | Product1 | Product2         | Category |
      |        4 | The Purple Mattress    | Purple Hybrid Premier Mattress | Bedding  |

  Scenario Outline: 5 Verify the error messages for invalid gift card
    Then user should able to add the product "<Product1>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to click "Add Gift Card" link
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the error message as "The gift card number is invalid, please contact customer support"

    Examples: 
      | GiftCard | Product1        | Category   |
      |       11 | The Purple Mattress | Mattresses |

  Scenario Outline: 6 Verify the error messages for zero balance gift card
    Then user should able to add the product "<Product1>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to click "Add Gift Card" link
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the balance amount on card as "$ 0.00"

    Examples: 
      | GiftCard | Product1   | Category   |
      |       10 | Purple Foundation | Bed Frames |

  Scenario Outline: 7 Verify the place holder text if entire cart value is paid using gift card
    Then user should able to add the product "<Product1>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then Enter respective Delivery details in Delivery info section <Iteration>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | DeliveryInfo |
      Then user should able to click "Add Gift Card" link
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the place holder text "You’re covered, no additional payment necessary."

    Examples: 
      | GiftCard | Iteration | Product1                  | Category |
      |        2 |         1 | Purple SoftStretch Sheets | Bedding  |

  Scenario Outline: 8 Verify the gift card application should reset once the page gets refreshed
    Then user should able to add the product "<Product1>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to click "Add Gift Card" link
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the gift card details below payment info title
    And user should able to view the remove button againt each gift card
    And user should able to view the balance amount of the gift card
    Then user refreshes the pages
    Then user should able to view the applied gift card details get reset

    Examples: 
      | GiftCard | Product1   | Product2  | Category   |
      |        1 | Foundation | PowerBase | Bed Frames |

  Scenario Outline: 9 Verify the error message is displayed when user apply same gift card twice
    Then user should able to add the product "<Product1>"
    Then user should able to land on Cart page
    Then user should able to click on Checkout button
    Then user should able to land on Checkout page
    Then user should able to click "Add Gift Card" link
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
     Then user should able to click "Add Gift Card" link
    Then user should able to enter the gift card number <GiftCard>
      | InputFileName    | SheetName    |
      | Purple_DataSheet | GiftCardData |
    Then user should able to click apply button
    Then user should able to view the place holder text "Gift Cart Already Applied."

    Examples: 
      | GiftCard | Product1                       | Category   |
      |        2 | Purple Hybrid Premier Mattress | Mattresses |
