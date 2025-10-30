# src/test/resources/features/TestSuite.feature
Feature: Test Suite Management

  @TestSuite
  Scenario: Successfully create a new test suite
    Given I am logged in for test suite management
    When I navigate to the "Test Suites" page
    And I click on the "Create Test Suite" button
    And I enter "My New Suite" as the test suite name
    And I click On the Save button
    And I click on Add Test Cases Button
    And I add a test case with title "Login"
    And I click on Select All Checkbox
    And I click on Add Selected Test Cases
