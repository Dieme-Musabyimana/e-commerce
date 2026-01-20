Feature: Sort Product
  As a customer
  I want to filter products by their categories
  so that I can only see the products of a specific category

  Scenario Outline: Filter products by categories
    Given I am on the store page
    When I select a product category "<category>"
    Then I should be taken to the page "<pageTitle>" of the selected category
    Examples:
      | category    | pageTitle      |
      | Accessories | Accessories |
      | Men         | Men         |
      | Women       | Women       |

