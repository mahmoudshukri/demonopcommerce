@smoke

  Feature: F05| hoverCategories
    Scenario: select random category from the three main categories
      Given User hover random on one of the three main category on the top menu
      When user click on random sub category of product and get Text
      Then verify if the category title is matching

