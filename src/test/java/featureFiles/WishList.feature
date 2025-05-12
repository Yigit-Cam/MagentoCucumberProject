Feature:

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right