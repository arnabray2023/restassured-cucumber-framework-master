
Feature: Create Post Tests - This feature includes tests that test the Create Post RESTFul services

  @smokeTest
  Scenario: Users are able to add POSTs to the system and verify the response data
    Given the Social Network API is available
    When I create a Post in the system
    Then the create post request response has a '201' response code
    And the create post requests response contains the correct json data

  @smokeTest
  Scenario: Users are able to delete POSTs from the system
    Given There is an existing Post
    When user deletes the existing Post
    And search for the Post by its id
    Then the requests response will be Empty

  @smokeTest
  Scenario: Users are able to add POSTs that have no tags
    Given the Social Network API is available
    Then User can add a Post that has no title

  @smokeTest
  Scenario: Id is automatically generated for POSTs when not supplied with the request
    Given the Social Network API is available
    When user made a post to the system without providing an id value
    Then an id is automatically generated for the newly added post

  @smokeTest
  Scenario: Adding a POST with no body for the request results in a 400 response
    Given the Social Network API is available
    When user create a POST and the json body is malformed and consists of only '{'
    Then the create post request response has a '400' response code
    Then the requests response will contain the value 'bad input' for the 'message' field
