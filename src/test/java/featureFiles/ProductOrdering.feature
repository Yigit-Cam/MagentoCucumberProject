Feature:

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right

    Given The user goes to the product selection page
    When User adds the product to the cart
    Then Fills in the required information for the product
    And See confirmation message added to cart
    Given User goes to the cart page

    Scenario: Product Order
    When User selects the payment transaction
    Then User clicks next button
    And User makes sure that the billing and shipping address are the same
    And User selects place order
    And The user receives a message that the order has been confirmed
