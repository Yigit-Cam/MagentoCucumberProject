Feature: Address deletion, addition and editing Functionality

  Background:


  Scenario: Address deletion, addition and editing
    When The user clicks on the drop-down menu next to their name in the top right corner and then on the My Account button
    And The user clicks on the Delete button and deletes their old address and the verification message is displayed
    And The user clicks on the Address Book button and then on the Add New Address button
    And Fills in user address information Checks for the existence of Default Shipping Address and Default Billing Address selections
    And The user clicks on the Save button and verifies the success message
    When The user clicks on the My Account button in the Left Nav and then on the Edit Address button
    And The user changes the address information they want to change
    Then The user clicks on Save button and displays verifies message

