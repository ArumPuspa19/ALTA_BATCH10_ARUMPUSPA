Feature: Users API Automation Testing QE-10
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send get lists users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user JSON Schema
    Examples:
      | page |
      | 1    |
      | 2    |
  @Latihan
  Scenario: post create new user with valid json
    Given Post create user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Arum" job was "admin"
    And Validate get create user JSON Schema