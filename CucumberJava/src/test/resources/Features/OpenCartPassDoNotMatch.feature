Feature: Sync Up

  Scenario: 
    Given User is on the Register page
    When User enters passwords that do not match
    Then Error message is displayed
