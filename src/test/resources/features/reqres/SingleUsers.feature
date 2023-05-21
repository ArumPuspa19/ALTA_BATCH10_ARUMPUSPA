Feature: Single Users API Automation Testing QE-10
@Tugas
Scenario Outline: Get single users with valid parameter id
Given Get single users with valid parameter <id>
When Send get single users
Then Status code should be 200 OK
And Response body Single page should be <id>
And Validate get single user JSON Schema
Examples:
| id |
| 1  |
| 2  |
@Tugas
Scenario Outline: Get single user with valid parameter to user not found
Given Get single user with invalid parameter <id>
When Send get single users
Then Status code should be 404 Not Found

Examples:
| id |
| 20 |
| 23 |