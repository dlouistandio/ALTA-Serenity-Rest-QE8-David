@GetFeature
Feature: Get List Users Reqres API

  Scenario Outline: Get list users with valid parameter page
    Given Get list user with page <page>
    When Send request get list user
    Then Should return status code 200
    And Response body page should be <page>
    And Validate json schema list user
    Examples:
      |page|
      |1   |
      |2   |

   Scenario Outline: Get single user with valid id
     Given Get list user with id <id>
     When Send request get user
     Then Should return status code 200
     And Response body page should be <id>
     And validate json schema list user
     Examples:
       | id |
       | 2  |
       | 3  |

   Scenario Outline: Get unregistered user
     Given Get list user with id <id>
     When Send request get user
     Then Should return status code 404
     Examples:
       | id   |
       | 2344 |
       | 6523 |

   Scenario Outline: Get list user with invalid path
     Given Get list user with invalid id "<id>"
     When Send request get user
     Then Should return status code 404
     Examples:
       | id         |
       | qwewqewqew |
       | &%*!&(@(^  |