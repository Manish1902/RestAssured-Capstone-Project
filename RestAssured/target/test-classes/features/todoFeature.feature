Feature: Advanced CRUD Operations on Todos

  Scenario: Partially Update a Todo
    Given The JSONPlaceholder API is available
    When I partially update the title of todo with ID "1" to "Partially Updated Title"
    Then The response should return a status code of 200
    And The todo title should be "Partially Updated Title"

  Scenario: Fetch All Todos
    Given The JSONPlaceholder API is available
    When I fetch all todos
    Then The response should return a status code of 200
    And The list of todos should not be empty

  Scenario: Filter Todos by Completed Status
    Given The JSONPlaceholder API is available
    When I fetch all todos with completed status "true"
    Then The response should return a status code of 200
    And All fetched todos should be completed

  Scenario: Validate Todo Not Found
    Given The JSONPlaceholder API is available
    When I fetch details for todo with ID "9999"
    Then The response should return a status code of 404
    And The response message should be "Not Found"
