# Login.feature
Feature: User Login Functionality
  As a user, I want to be able to log in to the application
  So that I can access my account features

	@Login
  Scenario: Successful Login with valid credentials
    Given I am on the login page
    When I enter a valid username and password
    And I click the login button
    Then I should be logged in successfully
  @Login
  Scenario: Unsuccessful Login with invalid credentials
    Given I am on the login page
    When I enter an invalid username and password
    And I click the login button
    Then I should see an error message
    And I should remain on the login page