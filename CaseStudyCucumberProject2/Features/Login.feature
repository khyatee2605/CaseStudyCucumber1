@FunctionalTest
Feature: To Check Login Functionality

  @SmokeTest
  Scenario Outline: To test multiple login functionality on TestMeApp
    Given User is on TestMeApp page
    When User enters "<username>" and "<password>"
    Then Display message Logged in Successfully

    Examples: 
      | username | password    |
      | katie26  | test02      |
      | Lalitha  | Password123 |
