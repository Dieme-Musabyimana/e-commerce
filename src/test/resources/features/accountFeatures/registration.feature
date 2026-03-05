Feature: Registration and Login functionality
  As a user
  I want to create an account
  So that I can log in and interact with personalized features

  Background:
    Given I am on the account page

  Scenario Outline: Successful registration with non-existing account
    When I enter unique credentials "<username>" "<email>" "<password>"
    And I click on register button
    Then I should be taken to the dashboard page

    Examples:
      | username | email            | password |
      | Didier   | didier@gmail.com | Didy1    |
      | Johnny   | johnny@gmail.com | John1    |
      | Pierre   | pierre@gmail.com | Peter1   |

  Scenario Outline: Unsuccessful registration with existing account
    When I enter credentials "<username>" "<email>" "<password>"
    And I click on register button
    Then I should see an "<error>" message

    Examples:
      | username | email         | password | error                         |
      | sam      | sam@gmail.com | Sam1     | account is already registered |

  Scenario Outline: Registration with invalid credentials
    When I enter credentials "<username>" "<email>" "<password>"
    And I click on register button
    Then I should see an "<error>" message

    Examples:
      | username | email          | password | error                         |
      | david   | david@gmailcom | David1   | provide a valid email address |
      |          | david@gmail.com | David1   | enter a valid account username|
      | david    |                 | David!   | provide a valid email address                             |
      |          |                 |          | provide a valid        -u         |