package com.automation.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.automation.pages.CreateTestRunPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.TestPlanPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import java.util.Map;
import java.time.Duration;

public class TestPlanSteps {

	private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private TestPlanPage testPlanPage = new TestPlanPage(DriverManager.getDriver()); 

    @Given("I am on the TestCopilot Test Plan page")
    public void i_am_on_the_test_runs_page() {
    	DriverManager.getDriver().get(ConfigReader.getProperty("base.url")); 
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login for test suite management.");
        testPlanPage.navigateToTestPlan();
    }

    @When("I click on Create Test Plan")
    public void iClickOnCreateTestPlan() {
        testPlanPage.clickCreateTestPlan();
    }

    @When("I fill the Test Plan form with valid details")
    public void iFillTheTestPlanFormWithValidDetails(DataTable dataTable) {
//        Map<String, String> data = dataTable.asMaps().get(0);
//        String title = data.get("title");
//        String startDate = data.get("startDate");
//        String endDate = data.get("endDate");
//        String description = data.get("description");

        testPlanPage.fillTestPlanForm();
    }

    @When("I click on Create")
    public void iClickOnCreate() {
        testPlanPage.clickCreateButtonInModal();
    }

    @Then("I should see a message confirming the creation of the Test Plan")
    public void iShouldSeeAMessageConfirmingCreation() {
    }
}
