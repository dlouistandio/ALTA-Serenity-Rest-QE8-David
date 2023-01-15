@Tugas
  Feature: Delete users Reqres API
    Scenario Outline: Delete user with valid id
      Given Delete user with valid id <id>
      When Send request delete user
      Then Should return status code 204
      Examples:
        | id |
        | 1  |
        | 2  |

    Scenario Outline: Delete user with unregistered id
      Given Delete user with unregistered <id>
      When Send request delete user
      Then Should return status code 400
      Examples:
        | id       |
        | 13774664 |
        | 456424   |


    Scenario Outline: Delete user with invalid id
      Given Delete user with invalid id "<id>"
      When Send request delete user
      Then Should return status code 400
      Examples:
        | id     |
        | )_%($  |
        | ?'sasq |

     Scenario: Delete user without paramater
       Given Delete user without parameter id
       When Send request delete user with empty id
       Then Should return status code 400