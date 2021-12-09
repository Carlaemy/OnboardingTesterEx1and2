Feature: My Account

  Scenario: User without wish list
    Given User is new and logged
    When User navigates to wishlist page
    Then Message detailing “Your wish list is empty”
