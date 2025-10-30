Feature: Test Case Generation from Figma

  As a QA engineer
  I want to generate test cases from a Figma file
  So that I can quickly create a test suite based on a design
 
  @GenerateTestCaseFromFigma
  Scenario: Successfully generate test cases from a Figma page
    Given I am on the Generate Test Case page
    When I enter a valid Figma API Token and Figma File Key
    And I click the "Fetch Pages" button
    Then I should see the list of Figma pages in the sidebar
    When I click on the "Login / Register Screens" page
    When I hover over "Register" frame
    And I click the Generate Test Cases button    
    Then a success message should be displayed
    And the generated test cases should be visible

  Scenario: Unsuccessful generation with invalid credentials
    Given I am on the Generate Test Case page
    When I enter an invalid Figma API Token or Figma File Key
    And I click the "Fetch Pages" button
    Then an error message "Invalid credentials" should be displayed
