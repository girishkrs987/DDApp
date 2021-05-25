@PDP-CertifiedCleanAir @purple1
Feature: Certified Clean Air and product overview in Product Detail page

  Background: 
    Given User Launches the browser for pdp pages

  # And User navigates to the Purple site
  @REP-807 @REP-3256
  Scenario Outline: 1 Ability of the user to view the Certified Clean Air section in Product detail page
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view the Certified Clean Air section
    Then user should able to view the Certified Clean Air section as "Certified Clean Air GOLD"
    Then user should able to view the description below the title
    Then user should able to view the relevant images to the left of the section

    Examples: 
      | Product1            |
      | Kid Purple Mattress |

  @REP-3257
  Scenario Outline: 2 Verify user able to view the Product over view section in product detail page
    Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view the Product Overview section
    Then user should able to view the Product Overview section title as "Overview"
    Then user should able to veiw the product Overview description on the left side
    Then user should able to veiw the product Overview Ticklist on the right side

    Examples: 
      | Product1                       |
      | Purple Hybrid Premier Mattress |
