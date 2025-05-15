@Smoke, @Regression
Feature: User Login Functionality

  Background:
    Given The user opens the Magento homepage
    When The user clicks the Sign In button
    Then The user should see Customer Login page

  Scenario: Successful login with valid credentials
    When User enters valid email and password
    Then The user should be redirected to the Home Page and see "Welcome" text in the upper right