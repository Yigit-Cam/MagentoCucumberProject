Feature: User Register Functionality

  Scenario: User registration completed successfully.
    Given The user opens the Magento homepage
    When The user click the option to register a create new account
    And The user form is displayed
    And The user fills the registration form with the following data
      | firstName       | lastName        | email              | password       | confirmPassword | action       |
      | randomFirstName | randomLastName  | randomEmailAddress | randomPassword | sameAsPassword  | clickSubmit  |
    Then A success message should be visible confirming the registration
    And The user should see their account dashboard
    When The user logs out by clicking Sign Out in the Customer dropdown menu.