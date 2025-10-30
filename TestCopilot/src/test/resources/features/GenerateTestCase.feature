# GenerateTestCase.feature
Feature: Test Case Generation from Screenshot
  As a quality assurance engineer
  I want to upload a screenshot
  So that TestCopilot can generate test cases from it
	
	@GenerateTestCase
  Scenario: Successfully generate test cases from a screenshot
    Given I am logged in as a valid user
    When I navigate to the "All Test Cases" page
    And I click on the "Generate Test Case" button
    And I select "Screenshot" as the generation option
    And I upload a valid screenshot file
    And I click the "Generate Test Case" button on the screenshot page
    Then the user should be redirected to generated test case view page
