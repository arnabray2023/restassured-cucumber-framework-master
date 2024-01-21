Social Network API Tests (Cucumber - Rest Assured) 
========================================
This is Automation Test Suite designed to test Social Network API services.

The project has 10 scenarios that that can be located within the feature files: 
 - src/test/resources/CreatePost.feature
 - src/test/resources/CommentonPosts.feature
 - src/test/resources/ListOfUsers.feature  

**CreatePost.feature scenarios include:**
   - Scenario: Users are able to add POSTs to the system and verify the response data
   - Scenario: Users are able to delete POSTs from the system
   - Scenario: Users are able to add POSTs that have no tags
   - Scenario: Id is automatically generated for POSTs when not supplied with the request
   - Scenario: Adding a POST with no body for the request results in a 400 response

**CommentonPosts.feature scenarios include:**
   - Scenario: Users are able to comment on a post using Post ID and verify the response data
   - Scenario: Users are able to search an existing Comment using its ID
   - Scenario: No message is displayed when searching for an Comment that does not exist

**ListOfUsers.feature scenarios include:**
   - Scenario: Check if users could be added to the system and verify the response data
   - Scenario: Users are searchable by their username
    
    
**Important Note:** 
Scenarios need to have the tag **@smokeTest** in order to be included in test executions


**Pre-requisites:**
- Java 1.8+ is required
- Maven Installed (I use version 3.5.2) OR Gradle 3.6.1
- Eclipse (Or another Java IDE)

**Important: No UPDATE/DELETE actions are not giving the correct response, hence test cases are focused only to test the Create/Accept Functionalities. This suite should work on both windows and mac platforms however has only been tested on a windows.**

In order to execute the automation suite navigate to the Project directory within a Terminal/CMD window and run the command: **'mvn clean test'**. OR
**'gradle clean test'**

10 Scenarios will be executed. Report file can be found *'target/reports/test-report/index.html'*

3 of the 10 test scenarios are failed and here is the analysis for the same -

**Failed scenarios:**

- **Feature File:** CreatePost.feature
- **Scenario:** Adding a POST with no body for the request results in a 400 response
- **Failure Reason:** This is a legitimate failure due to incorrect response code we are getting i.e. 500(Internal Server Error) instead of 400(Bad Request response) 

- **Feature File:** CommentonPosts.feature
- **Scenario:** Users are able to comment on a post using Post ID
- **Failure Reason:** The user is able to comment on the post, however when validating the postID in response data it is failing as the response is blank, this is failing as the response is incorrect for the API service

- **Feature File:** ListOfUsers.feature
- **Scenario:** Check if users could be added to the system
- **Failure Reason:** User is created successfully in the application. However, while retrieving the details for the newly created user, it is failing as the response is giving the list of users are present in the system not the user id that is assigned to the user. Rest all the JSON Response validation is successful for the request.


