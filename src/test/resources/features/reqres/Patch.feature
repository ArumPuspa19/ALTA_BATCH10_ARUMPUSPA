Feature: Patch API Automation Testing QE-10
  @Tugas
  Scenario Outline: Patch User with valid parameter id
    Given Patch user with valid json and id <id>
    When Send patch update user
    Then Status code should be 200 OK
    And Validate patch user JSON Schema

    Examples:
      | id |
      | 1  |
      | 2  |
