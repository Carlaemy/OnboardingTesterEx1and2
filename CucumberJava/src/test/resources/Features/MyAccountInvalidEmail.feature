Feature: My Account

  Scenario: Email is not correct
    Given User types an invalid email
    When User saves the changes
    Then Error message detailing “Email Address does not appear to be valid”
