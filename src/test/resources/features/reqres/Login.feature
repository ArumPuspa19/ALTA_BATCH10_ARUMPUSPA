Feature: Login API Automation Testing QE-10
  @Tugas
  Scenario: Post login successful
    Given Post login with valid json
    When Send post login successful
    Then Status code should be 200 OK
    And Validate login JSON Schema