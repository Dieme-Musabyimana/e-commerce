Scenario Outline: Place an order as a guest using <payment_method>
Given I am a guest customer
* I have a product in the cart
* I am on the checkout page
When I enter billing details
| firstname | lastname | country            | address_line1     | city  | state | zip   | email |
| <fname>   | <lname>  | <country>          | <address>         | <city>| <state>| <zip> | <email> |
* I select payment method "<payment_method>"
* I place the order
Then the order should be placed successfully
