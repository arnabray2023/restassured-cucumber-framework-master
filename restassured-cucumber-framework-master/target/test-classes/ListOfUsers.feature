
Feature: List of Users - This feature includes tests that test the List of Users RESTFul services

  @smokeTest
  Scenario: Check if users could be added to the system and verify the response data
    Given the Social Network API is available
    When I add a new user to the system
    Then the user request response has a '200' response code
    And the user requests response contains the correct json data

  @smokeTest  
  Scenario: Users are searchable by their username
    Given a valid user exists
    When I search for the user by their username
    Then the user is located
