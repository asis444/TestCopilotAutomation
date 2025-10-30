package com.automation.steps;

import com.automation.pages.GenerateTestCaseFromFigmaPage;
import com.automation.pages.GenerateTestCaseFromJiraPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GenerateTestCaseFromJiraSteps {

	 private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
	    private HomePage homePage = new HomePage(DriverManager.getDriver());
	    private GenerateTestCaseFromJiraPage jiraPage = new GenerateTestCaseFromJiraPage(DriverManager.getDriver());


	    private static final String JIRA_API_TOKEN = ConfigReader.getProperty("valid.apiToken");
	    private static final String JIRA_HOST_URL= ConfigReader.getProperty("valid.fileKey");
	    private static final String USER_EMAIL = ConfigReader.getProperty("valid.fileKey");


    @When("I navigate to the Jira Test Case Generator")
    public void iNavigateToTheJiraTestCaseGenerator() {
    	DriverManager.getDriver().get(ConfigReader.getProperty("base.url")); 
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login for test suite management.");
        homePage.navigateToAllTestCases();
        homePage.clickGenerateTestCaseButton();
        homePage.selectJiraGenerationOption();
    }

    @And("I enter my Jira host URL, email, and API token")
    public void iEnterMyJiraHostUrlEmailAndApiToken() {
        jiraPage.enterJiraAuthDetails();
    }
    
    @When("I click on Continue to Next.")
    public void iClickOnContinue() {
    	jiraPage.clickOnContinue();
    }

    @And("I select the project and user stories")
    public void iSelectTheProjectAndUserStories() {
        jiraPage.selectProjectAndUserStories();
    }
    
    @And("I click on Continue to Next Second.")
    public void iClickOnContinueSecond() {
    	jiraPage.clickOnContinueSecond();
    }

    @When("I click the 'Generate Test Cases' button")
    public void iClickTheGenerateTestCasesButton() {
        jiraPage.clickGenerateTestCasesButton();
    }

    @Then("I should see a success message that test cases are generated")
    public void iShouldSeeASuccessMessageThatTestCasesAreGenerated() {
    	jiraPage.isSuccessMessageDisplayed();
    	}

    @And("I should see the generated test cases")
    public void iShouldSeeTheGeneratedTestCases() {
        jiraPage.areTestCasesDisplayed();
    }
}
