@Tugas
Feature: Create new user Reqres API
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "David" and job should be "AltaQE8"
    And validate json schema new user

  Scenario: Post create new user with invalid json
    Given Post create user with invalid json
    When Send request post create user
    Then Should return status code 400

  Scenario: Post create new user with empty json key
    Given Post create user with empty json key
    When Send request post create user
    Then Should return status code 400

