@Tugas
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

  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid page "<page>"
    When Send request get user
    Then Should return status code 404
    Examples:
      | page       |
      | qwewqewqew |
      | &%*!&(@(^  |

   Scenario Outline: Get single user with valid id
     Given Get single user with id <id>
     When Send request get single user
     Then Should return status code 200
     And Response body id should be <id>
     And validate json schema single user
     Examples:
       | id |
       | 1  |
       | 2  |

  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get invalid user
    Then Should return status code 404
    Examples:
      | id   |
      | =_+6 |
      | 4%^n |

  Scenario Outline: Get unregistered user
     Given Get list user with unregistered id <id>
     When Send request get single user
     Then Should return status code 404
     Examples:
       | id   |
       | 2344 |
       | 6523 |




