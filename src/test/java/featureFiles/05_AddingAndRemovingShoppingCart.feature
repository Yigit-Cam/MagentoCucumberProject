@Smoke, @Regression
Feature:Adding products to the shopping cart product and removal Functionality

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right

  Scenario: Adding and removing products to cart
    Given The user goes to the product selection page
    When User adds the product to the cart
    Then Fills in the required information for the product
    And See confirmation message added to cart

    Given User goes to the cart page
    When User changes the number of products
    Then User updates the product
    And User deletes the product
    And The user receives a confirmation message that the product is not available