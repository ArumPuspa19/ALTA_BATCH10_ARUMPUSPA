Feature: Reqres API Automation Testing QE-10
  @Latihan
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body for put name was "Arum" job was "admin"
    And Validate put update user JSON Schema
    Examples:
      | id |
      | 1  |
      | 2  |
@Latihan
Scenario Outline: Delete user with valid parameter id
  Given Delete user with valid id <id>
  When Send delete user
  Then Status code should be 204 No Content
  Examples:
    | id |
    | 1  |
    | 2  |


