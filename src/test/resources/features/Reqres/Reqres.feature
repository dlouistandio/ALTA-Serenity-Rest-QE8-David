Feature: Testing Reqres API
  Scenario: Get list users with valid parameter page
    Given Get list user with page 2
    When Send request get list user
    Then Should return status code 200