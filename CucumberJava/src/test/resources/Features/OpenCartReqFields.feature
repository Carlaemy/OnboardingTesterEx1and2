Feature: Sign Up

In order to register a user


  Scenario: Verify Required Fields
    Given User is on the register page
    When User submits
    Then Error messages should be displayed on the fields


