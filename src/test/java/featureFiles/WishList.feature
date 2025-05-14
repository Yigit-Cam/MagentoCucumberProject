Feature:

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right

  Scenario: Creating a favourite list

    Given The user goes to the product selection page
    When The user goes to the page of the product they like
    And  The user clicks on the Add to Favourites button
    And  The user confirms that they have added the product to their favourites
    And  The user clicks on the Dropdown Menu and My Account button

    When The user clicks on the My Wish List button
    Then The user confirms that the product is on the favourite list
    When The user hover-overs over the product, user sees the removal icon from fovories
    And  The user clicks on the "Remove from Favourites" button next to the Product.
    Then The user Confirms that the Product has been removed from the favourites list

    When The user hovers over the product in the My Wish List and clicks the edit icon
    Then The user is directed to the page with product details

    When The user fills size colour and qty properties
    And  The user clicks on update wish list button
    Then The user is redirected to the My Wish List page
    And  The user hovers on "See Details", show product details
    And  The  user  hovers on "See Details"  in product, user see product details
    Then The user verifies that the product content has been updated




