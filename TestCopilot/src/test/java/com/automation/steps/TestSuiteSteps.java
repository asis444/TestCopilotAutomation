package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.TestSuitesPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TestSuiteSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private TestSuitesPage testSuitesPage; 

   
    @Given("I am logged in for test suite management")
    public void iAmLoggedInForTestSuiteManagement() {
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url")); 
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login for test suite management.");
    }

    @When("I navigate to the \"Test Suites\" page")
    public void iNavigateToTheTestSuitesPage() {
        homePage.navigateToTestSuites();
        testSuitesPage = new TestSuitesPage(DriverManager.getDriver()); 
    }

    @And("I click on the \"Create Test Suite\" button")
    public void iClickOnTheCreateTestSuiteButton() {
        testSuitesPage.clickCreateTestSuiteButton(); 
    }

    @And("I enter {string} as the test suite name")
    public void iEnterAsTheTestSuiteName(String suiteName) {
        testSuitesPage.enterTestSuiteName(suiteName);
    }

    @And("I click On the Save button")
    public void iClickOnTheSaveButton() {
        testSuitesPage.clickSaveTestSuiteButton();
    }
    
    @And("I click on Add Test Cases Button")
    public void iClickTheAddTestCases() {
        testSuitesPage.addTestCaseToSuite();
    }

    @And("I add a test case with title {string}")
    public void iAddATestCaseWithTitle(String testCaseTitle) {
        testSuitesPage.enterSearch(testCaseTitle);
    }
    
    @And("I click on Select All Checkbox")
    public void iclickOnSelectAllCheckBox() {
        testSuitesPage.clickOnSelectAllCheckbox();
    }
   
    @And("I click on Add Selected Test Cases")
    public void iclickOnAddSelectedTestCases() {
        testSuitesPage.clickOnAddSelected();
    }

}
