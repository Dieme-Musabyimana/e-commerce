Feature: Place order

Scenario Outline: Place an order as a guest using payment_method

Given I am on the store page
 * I have a product "<product-name>" in the cart
 * I am on the checkout page
 When I enter billing details
| firstname | lastname | country            | address_line1     | city  | state | zip   | email |
| didy      | mboka    | <countr          | <address>         | <city>| <state>| <zip> | <email> |
* I select payment method "<payment_method>"
* I place the order
Then the order should be placed successfully
  Examples:
  |product-name|
  |Black Over-the-shoulder Handbag|
