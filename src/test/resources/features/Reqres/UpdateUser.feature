@Tugas
  Feature: Update user Reqres API
    Scenario: Put update user with valid json and id
      Given Put update user with valid json and id 2
      When Send request put update user
      Then Should return status code 200
      And Response body name should be "David" and job should be "AltaQE8"
      And Validate json schema update user

    Scenario: Put update user with invalid json and valid id
      Given Put update user with invalid json and valid id 2
      When Send request put update user
      Then Should return status code 400
      
    Scenario: Put update user with valid json and invalid id
      Given Put update user with valid json and invalid id "@13_-21"
      When Send request put update user
      Then Should return status code 400

    Scenario: Put update user with empty json key and valid id
      Given Put update user with empty json key and valid id 2
      When Send request put update user
      Then Should return status code 400