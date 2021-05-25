@PDP-ProductQaulities @purple1
Feature: Product Qualities in Product Detail page

  Background: 
    Given User Launches the browser for pdp pages

  # And User navigates to the Purple site
  @REP-3473
  Scenario Outline: 1 Ability of the user to view the product qualities section in Product detail page
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view the product qualities section
    Then user should able to view the product quality icon for "HYPOALLERGENIC"
    Then user should able to view the procut quality text as "HYPOALLERGENIC" below the icon
    Then user should able to view the product quality icon for "Durable"
    Then user should able to view the procut quality text as "Durable" below the icon
    Then user should able to view the product quality icon for "Non-Toxic"
    Then user should able to view the procut quality text as "Non-Toxic" below the icon
    Then user should able to view the product quality icon for "Made in the USA"
    Then user should able to view the procut quality text as "Made in the USA" below the icon

    Examples: 
      | Product1                       |
      | Purple Hybrid Premier Mattress |

  
  Scenario Outline: 2 Verify user able to view the popup and its content for HYPOALLERGENIC product quality
    Then user should able to add the product "<Product1>"
    Then user should able to land on PDP page
    Then user should able to view the product qualities section
    Then user should able to click on the "HYPOALLERGENIC" qualities to open a popup
    Then user should able to view the popup with title "HYPOALLERGENIC" with logo on left side
    Then user should able to view the popup description
    Then user should able to view the Learn More link in popup
    Then user should able to close the popup to land on PDP page
    Then user should able to click on the "HYPOALLERGENIC" qualities to open a popup
    Then user should able to Click on learn more button and navigate to confirgured external page

    Examples: 
      | Product1                       |
      | Purple Hybrid Premier Mattress |

  
  Scenario Outline: 3 Verify user able to view the popup and its content for Durable product quality
    Then user should able to add the product "<Product1>"
    Then user should able to land on PDP page
    Then user should able to view the product qualities section
    Then user should able to click on the "Durable" qualities to open a popup
    Then user should able to view the popup with title "Durable" with logo on left side
    Then user should able to view the popup description
    Then user should able to view the Learn More link in popup
    Then user should able to close the popup to land on PDP page
    Then user should able to click on the "Durable" qualities to open a popup
    Then user should able to Click on learn more button and navigate to confirgured external page

    Examples: 
      | Product1                       |
      | Purple Hybrid Premier Mattress |

  
  Scenario Outline: 4 Verify user able to view the popup and its content for HYPOALLERGENIC product quality
    Then user should able to add the product "<Product1>"
    Then user should able to land on PDP page
    Then user should able to view the product qualities section
    Then user should able to click on the "Non-Toxic" qualities to open a popup
    Then user should able to view the popup with title "Non-Toxic" with logo on left side
    Then user should able to view the popup description
    Then user should able to view the Learn More link in popup
    Then user should able to close the popup to land on PDP page
    Then user should able to click on the "Non-Toxic" qualities to open a popup
    Then user should able to Click on learn more button and navigate to confirgured external page

    Examples: 
      | Product1                       |
      | Purple Hybrid Premier Mattress |

  Scenario Outline: 5 Verify user able to view the popup and its content for HYPOALLERGENIC product quality
    Then user should able to add the product "<Product1>"
    Then user should able to land on PDP page
    Then user should able to view the product qualities section
    Then user should able to click on the "Made in the USA" qualities to open a popup
    Then user should able to view the popup with title "Made in the USA" with logo on left side
    Then user should able to view the popup description
    Then user should able to view the Learn More link in popup
    Then user should able to close the popup to land on PDP page
    Then user should able to click on the "Made in the USA" qualities to open a popup
    Then user should able to Click on learn more button and navigate to confirgured external page

    Examples: 
      | Product1                       |
      | Purple Hybrid Premier Mattress |
