Feature: Category Management

  Scenario: Retrieving all categories
    Given the Lisbeer application is running
    When I request all categories
    Then the response status code should be 200
    And the response body should contain a list of categories

  Scenario: Creating a new category
    Given the Lisbeer application is running
    And I have a valid category representation
    When I create a new category with the representation
    Then the response status code should be 201
    And the response body should contain the created category

  Scenario: Creating a duplicate category
    Given the Lisbeer application is running
    And there exists a category with the same name
    When I create a new category with the same name
    Then the response status code should be 409
    And the response body should contain an error message