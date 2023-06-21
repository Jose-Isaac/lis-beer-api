Feature: Store Signup
  As a store owner
  I want to register my store in the system
  So that I can sell my products online

  Scenario: Successful store signup
    Given I am on the store signup page
    When I fill in the "fantasyName" field with "My Store"
    And I fill in the "email" field with "store@example.com"
    And I fill in the "password" field with "password123"
    And I fill in the "phoneNumber" field with "987654321"
    And I fill in the "street" field with "Main Street"
    And I fill in the "city" field with "My City"
    And I fill in the "state" field with "My State"
    And I fill in the "postalCode" field with "12345-678"
    And I fill in the "country" field with "My Country"
    And I fill in the "houseNumber" field with "123"
    And I fill in the "complement" field with "Apartment 4B"
    And I submit the store signup request
    Then I should receive a response with status code 200

  Scenario: Store signup with existing email
    Given I am on the store signup page
    When I fill in the "fantasyName" field with "Another Store"
    And I fill in the "email" field with "store@example.com"
    And I fill in the "password" field with "password456"
    And I fill in the "phoneNumber" field with "123456789"
    And I fill in the "street" field with "Main Street"
    And I fill in the "city" field with "My City"
    And I fill in the "state" field with "My State"
    And I fill in the "postalCode" field with "54321-987"
    And I fill in the "country" field with "My Country"
    And I fill in the "houseNumber" field with "456"
    And I fill in the "complement" field with "Apartment 2A"
    And I submit the store signup request
    Then I should receive a response with status code 409