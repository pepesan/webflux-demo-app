Feature: Testing MainController endpoints

  Scenario: Testing /api/main endpoint
    Given I send a GET request to "/api/main"
    Then the response status code should be 200

  Scenario: Testing /api/main/list-iterable endpoint
    Given I send a GET request to "/api/main/list-iterable"
    Then the response status code should be 200
