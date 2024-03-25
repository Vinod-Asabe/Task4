Feature: User Login

 Scenario: User login with valid credentials
    
Given User is on the login page with valid credentials from Excel
When User enters username and password
Then User clicks on login button
Then User should be logged in