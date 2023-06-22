Feature: Beer Management

  Scenario: Retrieve all beers
    Given the Lisbeer application is running
    When I request all beers
    Then the response status code should be 200
    And the response body should contain a list of beers

  Scenario: Create a new beer
    Given the Lisbeer application is running
    And I have a valid beer representation
    When I create a new beer with the representation
    Then the response status code should be 201
    And the response body should contain the created beer

  Scenario: Get beer details by ID
    Given the Lisbeer application is running
    And there is a beer with the specified ID
    When I request the details of the beer with the ID
    Then the response status code should be 200
    And the response body should contain the beer details

  Scenario: Get all beers by category ID
    Given the Lisbeer application is running
    And there is a category with the specified ID
    When I request all beers by category ID
    Then the response status code should be 200
    And the response body should contain a list of beers belonging to the category
