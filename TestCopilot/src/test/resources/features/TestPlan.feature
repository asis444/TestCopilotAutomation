Feature: Create a Test Plan
As a QA User
I want to create a new Test Plan
So that I can manage my test cases and test runs
@TestPlan
Scenario: Successfully create a new Test Plan
Given I am on the TestCopilot Test Plan page
When I click on Create Test Plan
And I fill the Test Plan form with valid details
And I click on Create
Then I should see a message confirming the creation of the Test Plan