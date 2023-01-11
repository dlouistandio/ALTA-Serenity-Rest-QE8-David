Feature: Testing Reqres API
  Scenario: Get list users with valid parameter page
    Given Get list user with page 2
    When Send request get list user
    Then Should return status code 200
    And Response body should be 2

  Scenario Outline: Get list users with valid parameter pages
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "David" and job should be "AltaQE8"