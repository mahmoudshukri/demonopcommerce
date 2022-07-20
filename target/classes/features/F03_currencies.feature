@smoke
Feature: F03_currencies | users could change currency

  Scenario: user could change currency from the top left drop down list
    Given user change currency to euro
    Then verify the currency symbol changed in the products