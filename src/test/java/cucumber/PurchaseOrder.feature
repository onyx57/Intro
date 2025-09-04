Feature: Purchase a product from Rahul Shetty Academy site

  Scenario: Successful product purchase
    Given I launch the application
    When I login with email "ktest@testt.com" and password "568956895689@xX"
    And I add a product to the cart
    And I checkout the product
    And I select country "Nigeria"
    Then I should be able to place the order successfully
