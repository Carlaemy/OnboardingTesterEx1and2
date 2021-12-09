Feature: My Account

Scenario: Changes on the Account information shows a confirmation message

	Given User is logged into the application
	When User updates the account information from the Edit page
	Then Friendly message detailing “Success: Your account has been successfully updated”