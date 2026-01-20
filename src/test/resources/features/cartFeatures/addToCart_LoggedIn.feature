Feature: Add products to cart as a Logged-in User

  As a registered customer
  I want to add products to my shopping cart
  So that I can review items before checkout

  Background:
    Given I am a logged-in user with credentials "didy" and "didy1"
  @cartManagement
  Scenario Outline: Add a product from Store page to cart as a logged-in user
    Given I am on the store page
    When I add the product "<product_name>" from store page to  the cart
    Then I should see 1 "<product_name>" from store page in the cart

    Examples:
      | product_name     |
      | Blue Shoes       |
      | Anchor Bracelet  |

  @cartManagement
  Scenario Outline: Add a product from Product page to cart as a logged-in user
    Given I am on the Product page for "<product_name>"
    When I add the product "<product_name>" from the product page to the cart
    Then I should see 1 "<product_name>" from product page in the cart

    Examples:
      | product_name     |
      | Black Over-the-shoulder Handbag  |
