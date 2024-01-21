
Feature: Comment on Post Tests - This feature includes tests that test the Comment on Post RESTFul services

  @smokeTest
  Scenario: Users are able to comment on a post using Post ID and verify the response data
    Given the Social Network API is available
    When user add a comment on a post using Post ID of '58'
    Then the comment on post request response has a '201' response code
    And the comment on post requests response contains the correct json data

  @smokeTest
  Scenario: Users are able to search an existing Comment using its ID
    Given Some comment exists for a Post
    When user search for the Comment by its id
    Then the complete Comment is returned

  @smokeTest
  Scenario: No message is displayed when searching for an Comment that does not exist
    Given the Social Network API is available
    When user search for a Comment with an id value of '1123332'
    Then the requests response will be Empty
