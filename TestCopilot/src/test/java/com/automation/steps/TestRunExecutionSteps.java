package com.automation.steps;

import com.automation.pages.TestRunExecutionPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.pages.BasePage;
import com.automation.pages.CreateTestRunPage;
import com.automation.pages.GenerateTestCaseFromFigmaPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TestRunExecutionSteps {
    
	private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());
	private CreateTestRunPage ctp = new CreateTestRunPage(DriverManager.getDriver());
    private TestRunExecutionPage testRunExecutionPage = new TestRunExecutionPage(DriverManager.getDriver());

    
    @Given("I am on the Test Runs page")
    public void i_am_on_the_test_runs_page() {
    	DriverManager.getDriver().get(ConfigReader.getProperty("base.url")); 
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login for test suite management.");
    	ctp.navigateToTestRun();
    }

    @When("I open the test run {string}")
    public void i_open_the_test_run_with_title(String testRunTitle) {
        testRunExecutionPage.openTestRun(testRunTitle);
    }

    @And("I open the test case with ID {string}")
    public void i_open_the_test_case_with_id(String testCaseId) {
        testRunExecutionPage.openTestCase(testCaseId);
    }
    
    @And("I set status of a test step")
    public void i_set_status_of_the_step() {
    	testRunExecutionPage.setTestCaseStatus();
    }
    
    @And("I add the defect")
    public void i_add_the_defect() {
    	testRunExecutionPage.addDefect();
    	}

    @And("I set the test case overall status")
    public void i_set_the_test_case_overall_status_to() {
        testRunExecutionPage.setGlobalStatus();
    }
    
}