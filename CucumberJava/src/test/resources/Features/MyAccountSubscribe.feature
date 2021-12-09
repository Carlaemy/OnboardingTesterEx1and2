Feature: My Account

  Scenario: User is abe to subscribe and un-subscribe a newsletter
    Given User is on the Edit information page
    When User enables the subscribe option
    Then The changes should be saved
