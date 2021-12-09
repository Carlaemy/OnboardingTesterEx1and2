Feature: Sync UP
Scenario: Email cannot be invalid
Given User fills an invalid email
	When User submits the changes
	Then Error message detailing “Please include an @ in the e-mail address”