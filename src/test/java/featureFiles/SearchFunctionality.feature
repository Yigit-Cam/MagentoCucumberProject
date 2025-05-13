Feature: Search Functionality

  Scenario: Search for an item (Positive)
    Given The user navigate to the homepage
    And The user see the search bar
    When The user enter in the search bar
    And The user click the search button
    And The user should see a list of Lando Gym Jacket
    And The user clicks on the product Lando Gym Jacket by following Home > Men > Tops > Jackets.
    Then The user verifies that the SKU number is MJ08 on the product detail page.

  Scenario: Search for a non-existent item (Negative)
    Given The user navigate to the homepage
    And The user see the search bar
    When The user enters the wrong word in the search bar
    And The user click the search button
    Then The user should see a message saying Your search returned no results.