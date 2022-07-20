@smoke
Feature: F04_Search | user could search using product name

Scenario Outline: user could search using product name
  Given user click on search box
  When user Enter productName as "<productName>"
  And user click on search button
  Then verify url contains "<productName>"
  And verify result contains "<productName>"
  And verify the Count number of search "<productName>"


  Examples:
    |productName|
    |book|
    |laptop|
    |nike|




  Scenario Outline: user could search for product using sku
    Given user click on search box
    When user Enter productName as "<sku>"
    And user click on search button
    Then verify result contains "<productName>"


    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|