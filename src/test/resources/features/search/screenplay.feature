Feature: Screenplay pattern

  Scenario: This is get scenario
    Given Govinda has capability to call rest api
    When he makes a get request
    Then he see the expected data is returned

  Scenario: This is post scenario
    Given Govinda has capability to call rest api
    When he makes post call with endpoint "/user"
    Then he verify that user is created and Id is generated
    When he creates a user govinda.gupta@test.com,Test1234
    Then he verify that user is created and Id is generated
    When he makes post call with endpoint "/user" to create users
    |email                  | password        |
    |govinda.gupta@test     | Test1234       |
    When he makes post call with endpoint "/user" with user data
    """list_of_users
    govinda.gupta@test.com,Test1234
    """
