package com.automation.steps;

import com.automation.pages.CreateTestRunPage;
import com.automation.pages.GenerateTestCaseFromFigmaPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.TestSuitesPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class CreateTestRunSteps {

	private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private CreateTestRunPage createTestRunPages = new CreateTestRunPage(DriverManager.getDriver()); 

    @When("I navigate to the Test Run page")
    public void i_navigate_to_the_test_run_page() {
    	DriverManager.getDriver().get(ConfigReader.getProperty("base.url")); // Navigate to login page
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login for test suite management.");
        createTestRunPages.navigateToTestRun();
    }

    @And("I click on the Create Test Run button")
    public void i_click_on_the_create_test_run_button() {
        createTestRunPages.clickCreateTestRunButton();
    }

    @And("I enter the mandatory details with title {string}")
    public void i_enter_the_mandatory_details_with_title(String title) {
        createTestRunPages.enterRunTitle(title);
    }

    @And("I click on the add test cases button")
    public void i_click_on_the_add_test_cases_button() {
        createTestRunPages.clickAddTestCases();
    }

    @And("I select the test case")
    public void i_select_the_test_case_with_id() {
        createTestRunPages.selectTestCase();
    }

    @And("I click on the Assign to Run button")
    public void i_click_on_the_assign_to_run_button() {
        createTestRunPages.clickAssignToRun();
    }

    @And("I click on the create button inside the test run pop-up")
    public void i_click_on_the_create_button_inside_the_test_run_pop_up() {
        createTestRunPages.clickCreateButton();
    }

    @Then("a new test run with title {string} should be created successfully")
    public void a_new_test_run_with_title_should_be_created_successfully(String title) {
        // This is a placeholder for your verification step.
        // You would typically find and verify the new test run on the table.
        // Example:
        // WebElement newRunTitle = driver.findElement(By.xpath("//div[normalize-space(.)='" + title + "']"));
        // assertTrue(newRunTitle.isDisplayed());
        System.out.println("Verification step for new run with title: " + title);
    }
}
