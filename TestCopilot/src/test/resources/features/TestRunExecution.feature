@MarkTestRunStatus
Feature: Mark a test case status inside a test run
	
	@TestRunExecution
  Scenario Outline: Successfully update the status of a test case inside a test run
    Given I am on the Test Runs page
    When I open the test run "Run 1"
    And I open the test case with ID "TC040"
    And I set status of a test step
    And I add the defect
    Then I set the test case overall status

  