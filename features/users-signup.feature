Feature: Signup
  As a new user
  I want to create an account in the system
  To have access to restricted features

  Scenario: Successful registration
    Given that I am on the signup page
    When I fill the "username" field with "fulano"
    And I fill the "email" field with "fulano@example.com"
    And I fill the "password" field with "123456"
    And I submit the signup request
    Then I should receive a response with status code 200
    And I should receive the id, username, and email in the response body

  Scenario: Registration with existing email
    Given that I am on the signup page
    When I fill the "username" field with "fulado2"
    And I fill the "email" field with "fulano@example.com"
    And I fill the "password" field with "123456"
    And I submit the signup request
    Then I should receive a response with status code 409
    And I should receive an error message stating that the email is already in use

  Scenario: Registration with existing username
    Given that I am on the signup page
    When I fill the "username" field with "fulado"
    And I fill the "email" field with "fulano2@example.com"
    And I fill the "password" field with "123456"
    And I submit the signup request
    Then I should receive a response with status code 409
    And I should receive an error message stating that the username is already in use