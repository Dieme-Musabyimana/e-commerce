Feature: Remove product from the cart

  As a shopper
  I want to remove products from my cart
  So that I can manage items before checkout


  Rule: Guest user removes a product from the cart

    Background:
      Given I am on the store page

    Scenario Outline: Remove product from the cart as a guest user
      And I have product "<product_name>" in the cart
      When I remove the product from the cart
       Then I should see a success alert message containing "<product_name>"
      Then the product should be successfully removed

      Examples:
        | product_name                    |
        | Black Over-the-shoulder Handbag |


  Rule: Logged-in user removes a product from the cart

    Background:
      Given I am a logged-in user with credentials "didy" and "didy1"
      And I am on the store page

    Scenario Outline: Remove product from the cart as a logged-in user
      And I have product "<product_name>" in the cart
      When I remove the product from the cart

      Then I should see a success alert message containing "<product_name>"
      And the product should be successfully removed

      Examples:
        | product_name                    |
        | Black Over-the-shoulder Handbag |
