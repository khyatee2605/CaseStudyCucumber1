
@Functionaltest
Feature: To check Cart Functionality

  @UI
  Scenario: The one where the user moves to cart without adding any item in it
    Given User has registered to TestMeApp
    When User searches for a particular product like Headphone
    And Try to proceed to payment without adding any item in the cart
    Then TestMeApp doesnt display cart icon
