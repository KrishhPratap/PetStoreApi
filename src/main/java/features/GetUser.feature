Feature: Get User by Username from api
  Scenario: Verify the get api for the User
    Given I hit the url of get user api endpoint
    When I pass the url in as request with username
    Then I get the response code as 200

  Scenario: Verify the user name is correct
    Given I hit the url of get user api endpoint
    When I pass the url in as request with username
    Then I verify the UserName of given user <username>
    Example:
      |username|
      |krishan |