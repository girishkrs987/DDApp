@CartAOVSection @purple11 @sprint9
Feature: AOV section

  Background: 
    #Given User Launches the browser
    Given User Launches the browser for pdp pages

  #And User navigates to the Purple site
  
  @REP-4029
  Scenario Outline: Verify if only a single slide with 3 products appearing in the AOV section
    #Then user should able to add the product "<Product1>" from "<Category>"
    #Then user should able to click on view cart button
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user should able to view the AOV section
    Then User should be able to view maximum 3 products in the single slide

    Examples: 
      | Iteration | Product1            | Category   |
      |         1 | The Purple Mattress | Mattresses |

  Scenario Outline: Verify that AOV bundle shown for the product with highest price without discount
    Then user should able to add the product "<Product1>"
    Then user should able to add the product "<Product2>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user should able to view the AOV section
    Then user should be able to view the AOV bundle of Hybrid mattress is displayed as it has highest pricing

    Examples: 
      | Iteration | Product1            | Product2               | Category   |
      |         1 | The Purple Mattress | Purple Hybrid Mattress | Mattresses |

  

  Scenario Outline: Verify that AOV section gets hidden when all products from AOV is added
    Then user should able to add the product "<Product1>"
    Then user clicks cart icon in header section
    Then user should able to land on Cart page
    Then user should able to view the AOV section
    Then user should be able to add all the products from AOV section
    Then user should not be able to view the AOV section

    Examples: 
      | Iteration | Product1        | Category   |
      |         1 | Purple Hybrid Mattress | Mattresses |
