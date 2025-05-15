Feature: User Login and Logout Functionality

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

  Scenario: Successful login with valid credentials
    When The user logs in with credentials from row 1
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right
    When The user logs out by clicking Sign Out in the Customer dropdown menu.

  Scenario: Login with null email
    When The user logs in with credentials from row 2
    Then The user should see for null email error message

  Scenario: Login with invalid email format
    When The user logs in with credentials from row 3
    Then The user should see invalid email error message

  Scenario: Login with null password
    When The user logs in with credentials from row 4
    Then The user should see for null password error message

  Scenario: Login with incorrect password
    When The user logs in with credentials from row 5
    Then The user should see wrong password error message

  Scenario: Navigate to forgot password page
    When The user clicks the Forgot Your Password? link
    Then The user should see the Forgot Your Password? page