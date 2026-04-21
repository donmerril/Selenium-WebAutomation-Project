Feature: Validate login functionality in saucedemo website

  Scenario: Verify Successful login with valid credentials
    Given user is on login page
    When user attempts login with username "standard_user" and password "secret_sauce"
    Then user should be navigated to products page

  Scenario: Verify login failure with invalid credentials
    Given user is on login page
    When user attempts login with username "standard_userrr" and password "secret"
    Then an error messege should be displayed saying "Username and password do not match any user in this service"

  Scenario: Verify login failure with empty username
    Given user is on login page
    When user attempts login with username "" and password "secret"
    Then an error messege should be displayed saying "Username is required"

  Scenario: Verify login failure with empty password
    Given user is on login page
    When user attempts login with username "standard_user" and password ""
    Then an error messege should be displayed saying "Password is required"

  Scenario: User logs out successfully
    Given User is logged in and on the product page
    When the user logs out
    Then the user should be redirected to the login page
