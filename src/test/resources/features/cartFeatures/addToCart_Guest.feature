Feature: Add products to cart as a Guest User
  As a guest shopper
  I want to add products to my shopping cart
  So that I can review selected items before checkout

  @cartManagement
  Scenario Outline: Add a product from Store page to cart as a guest
    Given I am on the store page
    When I add the product "<product_name>" from store page to  the cart
    Then I should see 1 "<product_name>" from store page in the cart

    Examples:
      | product_name     |
      | Anchor Bracelet  |
      | Dark Brown Jeans |
      |Black Over-the-shoulder Handbag|

  @cartManagement
  Scenario Outline: Add a product from Product page to cart as a guest
    Given I am on the Product page for "<product_name>"
    When I add the product "<product_name>" from the product page to the cart
    Then I should see 1 "<product_name>" from product page in the cart

    Examples:
      | product_name   |
      |Boho Bangle Bracelet|
      |Blue Denim Shorts   |
      |Dark Brown Jeans    |


