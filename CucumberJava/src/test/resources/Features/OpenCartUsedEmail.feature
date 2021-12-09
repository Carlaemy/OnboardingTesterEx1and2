Feature: Sign Up

  Scenario: Emails cannot be duplicated
    Given User has filled all fields
    When User Submits
    Then Error message detailing “E-mail address is already registered”
    

   


