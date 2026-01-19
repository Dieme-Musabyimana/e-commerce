Feature: Remove product from the cart
Rule:
  Background:
  Given I am on the store page

  Scenario Outline: Remove product from the cart as the the guest user
    And I have product "<product_name>" in the cart
    When I remove product from the cart
    Then the product should be successfully removed
    And I should see success alert message containing removed "<product-name>"
    Examples:
    |product_name|
    |Black Over-the-shoulder Handbag|

    Rule:
    Background:
      Given I am a logged-in user with credentials "didy" and "didy1"
      And I am on the store page
  Scenario Outline: Remove product from the cart as the logged in user
      And I have product "<product_name>" in the cart
      When I remove product from the cart
      Then the product should be successfully removed
    And I should see success alert message containing removed "<product-name>"
      Examples:
      |product_name|
      |Black Over-the-shoulder Handbag|
    