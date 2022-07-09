Feature: Techfios billing Login Functionality Validation

  Background: 
     Given User is on Techfios login page

@TF_login1 @smoke
Scenario: User should be able to login with valid credantials
When User enters username as "demo@techfios.com"
When User  enters password as "abc123"
When User click signin button
Then User should land on dashboard page

@TF_login2
Scenario: User should be able to login with valid credantials from Database
When User enters "username" from database
When User enters "password" from database
When User click signin button
Then User should land on dashboard page