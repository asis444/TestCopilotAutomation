Feature: Create a new test run

	@CreateTestRun
  Scenario Outline: Successfully create a new test run with selected test cases
    When I navigate to the Test Run page
    And I click on the Create Test Run button
    And I enter the mandatory details with title "Run 1"
    And I click on the add test cases button
    And I select the test case
    And I click on the Assign to Run button
    And I click on the create button inside the test run pop-up
    Then a new test run with title "<run_title>" should be created successfully


