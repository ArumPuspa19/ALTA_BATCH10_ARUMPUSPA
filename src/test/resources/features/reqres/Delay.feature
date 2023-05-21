Feature: Delay API Automation Testing QE-10
  @Tugas
  Scenario Outline: Delay respon with valid parameter time
    Given Delay respon with valid parameter <time>
    When Send response delay
    Then Status code should be 200 OK
    And Validate delay page JSON Schema
    Examples:
      | time |
      | 2    |
      | 3    |

