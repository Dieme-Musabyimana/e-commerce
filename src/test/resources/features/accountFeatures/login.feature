Feature: Login functionality
  As a user
  I want to log in to my account
  So that I can access my dashboard or see proper error messages

  Background:
    Given I am on the account page

  Scenario Outline: Login with registered valid credentials
    When I enter credentials "<username>" "<password>"
    And I click on login button
    Then I should be taken to the dashboard page

    Examples:
      | username | password |
      | didy     | didy1    |

  Scenario Outline: Unsuccessful login with non-existing account
    When I enter credentials "<username>" "<password>"
    And I click on login button
    Then I should see an "<error>" message

    Examples:
      | username | password | error                  |
      | Soso     | Soso!1   |  is not registered on this site |

  Scenario Outline: Unsuccessful login with invalid email format
    When I enter credentials "<email>" "<password>"
    And I click on login button
    Then I should see an "<error>" message

    Examples:
      | email        | password | error         |
      | nana@gmail   | Nana!    |  is not registered |
      |              | 123      |  Username is required |
      |nana          |          |  password field is empty|

  Scenario Outline: Unsuccessful login with wrong password
    When I enter credentials "<username>" "<password>"
    And I click on login button
    Then I should see an "<error>" message

    Examples:
      | username | password | error          |
      | didy     | Nana!12  | is incorrect |
