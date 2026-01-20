Feature: Product Filtering by Price Range

  As a customer
  I want to filter products by a specific price range
  So that I can quickly find items within my budget

  Scenario Outline: Filter products by price range
    Given I am on the store page
    And I filter products between <minPrice> and <maxPrice>
    Then all displayed products should be priced between <minPrice> and <maxPrice>

    Examples:
      | minPrice | maxPrice |
      | 50       | 100      |
      | 100      | 5000     |