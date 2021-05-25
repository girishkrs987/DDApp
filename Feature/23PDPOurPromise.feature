@PDP-OurPromise @purple
Feature: Our Promise Section in PDP

  Background: 
    Given User Launches the browser for pdp pages

  @REP-3255
  Scenario Outline: 1 Verify user able to view the Our Promise Section in PDP
   Then user should able to add the product "<Product1>"
    #Then user should able to click on view cart button
    Then user should able to land on PDP page
    Then user should able to view the Our promise section
     Then user should able to view the Our promise icon for "HYPOALLERGENIC"
    Then user should able to view the Our promise text as "HYPOALLERGENIC" below the icon
    Then user should able to view the Our promise icon for "Durable"
    Then user should able to view the Our promise text as "Durable" below the icon
    Then user should able to view the Our promise icon for "Non-Toxic"
    Then user should able to view the Our promise text as "Non-Toxic" below the icon
    Then user should able to view the Our promise icon for "Made in the USA"
    Then user should able to view the Our promise text as "Made in the USA" below the icon
    Then user should able to view the logo & promise text for each promise
  
	Scenario Outline: 2 Verify user able to click on the promises to open a pop up
		Then user should able to hover over the promises and see it getting highlighted
    Then user should able to click on the promises to open a pop up
    Then user should able to view image, title, description, close button and learn more button in the pop up
    Then user should able to click on the close button to close the pop up
    Then user should able to click on the Learn More button to navigate to the relevant page
    Then user should able to view the learn more button should not be shown, if the learn more link is not configured
    
	Scenario Outline: 3 Verify user able to view the Our Promise UI should auto align based on the number of promises applicable to a product
    Then user should able to view if there is only one promise is applicable, then it should be center aligned
    And user should able to view if there are no promises mapped to a product, the section should be hidden