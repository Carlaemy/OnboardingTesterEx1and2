
Feature: Feature to test login funcitonality

  Scenario: Check login successful with valid credentials
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is navigated to the home page

  
