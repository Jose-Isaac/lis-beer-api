Feature: Login
  As a registered user
  I want to authenticate myself in the system
  So that I can access restricted features

  Scenario: Login with valid credentials
    Given I am on the login page
    When I fill in the "email" field
    And I fill in the "senha" field
    And I send the login request
    Then I should receive a response with status code 200
    And the response should contain the authorization token in the header

  Scenario: Login with invalid password
    Given that I am on the login page
    When I fill in the "email" field with valid email
    And I fill in the "password" field with invalid password
    And I send the login request
    Then I should receive a response with status code 403

  Scenario: Login with invalid email
    Given that I am on the login page
    When I fill in the "email" field with invalid email
    And I fill in the "password" field with valid password
    And I send the login request
    Then I should receive a response with status code 403
