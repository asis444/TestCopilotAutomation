package com.automation.steps;

import com.automation.pages.GenerateTestCaseFromFigmaPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GenerateTestCaseFromFigmaSteps {

    
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private GenerateTestCaseFromFigmaPage generateTestCaseFromFigmaPage = new GenerateTestCaseFromFigmaPage(DriverManager.getDriver());


    private static final String FIGMA_API_TOKEN = ConfigReader.getProperty("valid.apiToken");
    private static final String FIGMA_FILE_KEY = ConfigReader.getProperty("valid.fileKey");


    @Given("I am on the Generate Test Case page")
    public void iAmOnTheGenerateTestCasePage() {
    	DriverManager.getDriver().get(ConfigReader.getProperty("base.url")); 
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login for test suite management.");
        homePage.navigateToAllTestCases();
        homePage.clickGenerateTestCaseButton();
        homePage.selectFigmaGenerationOption();
    }

    @When("I enter a valid Figma API Token and Figma File Key")
    public void iEnterAValidFigmaApiTokenAndFigmaFileKey() {
    	generateTestCaseFromFigmaPage.enterValidCredentials();
    }
    
    @When("I enter an invalid Figma API Token or Figma File Key")
    public void iEnterAnInvalidFigmaApiTokenOrFigmaFileKey() {
    	generateTestCaseFromFigmaPage.enterInvalidCredentials();
    }

    @And("I click the {string} button")
    public void iClickFetchPages(String buttonText) {
        generateTestCaseFromFigmaPage.clickFetchPages();
    }
    
    @Then("I should see the list of Figma pages in the sidebar")
    public void iShouldSeeTheListOfFigmaPagesInTheSidebar() {
    	generateTestCaseFromFigmaPage.waitForPagesSidebar();
        
    }
    
    @When("I click on the {string} page")
    public void iClickOnThePage(String pageName) {
        generateTestCaseFromFigmaPage.clickSidebarPage(pageName);
    }
    
    @When("I hover over {string} frame")
    public void iClickOnTheFrame(String frameName) {
        generateTestCaseFromFigmaPage.hoverOverFrame(frameName);
    }

    @And("I click the Generate Test Cases button")
    public void iClickTheGenerateTestCasesFromFigmaButton() {
        generateTestCaseFromFigmaPage.clickGenerateTestCases();
    }
    
    @Then("a success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        generateTestCaseFromFigmaPage.isSuccessMessageDisplayed();
    }

    @Then("the generated test cases should be visible")
    public void theGeneratedTestCasesShouldBeVisible() {
        generateTestCaseFromFigmaPage.areGeneratedTestCasesVisible();
       
}
}
