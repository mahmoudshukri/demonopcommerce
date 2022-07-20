@smoke
Feature: F08| Wishlist Feature


  Scenario: add item to wishlist by clicking heart button
    Given User add an item to wishlist by clicking the heart symbol
    Then The message The product has been added to your wishlist appear

  Scenario: user verify item added to cart
    Given User add an item to wishlist by clicking the heart symbol
    When User waits after adding the item to his wishlist
    And User navigates to the wishlist page
    Then verify that quantity is not equal zero