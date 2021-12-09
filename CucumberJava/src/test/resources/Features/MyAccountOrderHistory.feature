Feature: My Account

  Scenario: User does not have an order history
    Given User is authenticated to the application
    When User navigates to the order page
    Then A message should be displayed saying “You have not made any previous orders”
