Feature: Address deletion, addition and editing Functionality

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right

  Scenario: Address addition and editing
    When The user clicks on the drop-down menu next to their name in the top right corner and then on the My Account button
    And The user clicks on the Address Book button and then fills in the address information
    Then The user clicks on the Save button and verifies the success message
    And Add the new address and Checks for the existence of Default Shipping Address and Default Billing Address selections
    When The user clicks on the My Account button in the Left Nav and then on the Edit Address button
    And The user changes the address information they want to change
    Then The user clicks on the Save button and verifies the success message

  Scenario: Address deletion
    When The user clicks on the drop-down menu next to their name in the top right corner and then on the My Account button
    And The user clicks on the Address Book button
    And The user clicks on the Delete button and deletes their old address and the verification message is displayed

