Feature: Update cart
  As a customer
  I want to update my cart
  So that I can have the desired quantity of products before checkout

  Scenario Outline: Updating product quantity
    Given I am on the cart page
    And I have product "<product-name>" in the cart
    When I change the quantity "<quantity>" of the product
    And I update the cart
    Then I should see the right sub-total quantity "<sub-total>