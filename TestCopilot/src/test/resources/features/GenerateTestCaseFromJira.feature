Feature: Jira Test Case Generation

	@GenerateTestCaseFromJira
  Scenario: Successfully generate test cases from Jira
    When I navigate to the Jira Test Case Generator
    And I enter my Jira host URL, email, and API token
    When I click on Continue to Next.
    And I select the project and user stories
    And I click on Continue to Next Second.
    And I click the 'Generate Test Cases' button
    Then I should see a success message that test cases are generated
    And I should see the generated test cases