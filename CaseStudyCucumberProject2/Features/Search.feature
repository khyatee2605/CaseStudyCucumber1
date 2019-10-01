@FunctionalTest
Feature: To check Search Functionality

  @SmokeTest
  Scenario: To check search functionality
    Given User is logged in
    When user enters four characters on search page
    Then Product should be displayed in the drop down
