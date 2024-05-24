
@Demo_Employee_API
Feature: Demo API test to create and search employee
 
  @API @CreateEmployee
  Scenario Outline: Administrator creates new Employee record in Database
    Given Administrator creates new employee with details such as Name "<name>", Salary "<salary>", Age "<age>"
    Then Admin validates status code "<statusCode>"
 
    Examples:
      | name           | salary | age | statusCode |
      | SathishhKumar1 |  94000 |  24 |        200 |
 
  @API @GetEmployee
  Scenario Outline: Administrator searches the employee with id
    Given Administrator Searches employee with Id "<employeeId>"
    Then Admin validates status code "<statusCode>"
 
    Examples:
      | employeeId | statusCode |
      |       6165 |        200 |
 