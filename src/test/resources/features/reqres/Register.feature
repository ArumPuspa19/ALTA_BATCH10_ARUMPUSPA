Feature: Register API Automation Testing QE-10
  @Tugas
  Scenario: Post create new register with valid json
    Given Post create register with valid json
    When Send post create register
    Then Status code should be 200 OK
    And Validate create new user JSON Schema