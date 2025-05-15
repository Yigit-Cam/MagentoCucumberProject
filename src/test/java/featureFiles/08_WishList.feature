Feature: Wish List Functionality

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right

  Scenario: Creating a favourite list

    Given The user goes to the product selection page
    And  The user clicks on the Add to Favorites button
    And  The user confirms that they have added the product to their favorites
    And User deletes a product from wishlist
    Then the user checks the number of products in the wishlist