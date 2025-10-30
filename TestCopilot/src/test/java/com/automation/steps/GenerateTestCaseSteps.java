package com.automation.steps;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.GenerateTestCasePage; 
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths; 

public class GenerateTestCaseSteps {
    private LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private HomePage homePage = new HomePage(DriverManager.getDriver());
    private GenerateTestCasePage generateTestCasePage = new GenerateTestCasePage(DriverManager.getDriver());

    @Given("I am logged in as a valid user")
    public void iAmLoggedInAsAValidUser() {
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url"));
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login.");
    }

    @When("I navigate to the \"All Test Cases\" page")
    public void iNavigateToTheAllTestCasesPage() {
        homePage.navigateToAllTestCases();
    }

    @And("I click on the \"Generate Test Case\" button")
    public void iClickOnTheGenerateTestCaseButton() {
        homePage.clickGenerateTestCaseButton();
    }

    @And("I select \"Screenshot\" as the generation option")
    public void iSelectScreenshotAsTheGenerationOption() {
        homePage.selectScreenshotGenerationOption();
    }

    @And("I upload a valid screenshot file")
    public void iUploadAValidScreenshotFile() {
        String configuredFilePath = ConfigReader.getProperty("screenshot.file.path");
        String absoluteFilePath;

        Path path = Paths.get(configuredFilePath);
        if (path.isAbsolute()) {
            absoluteFilePath = configuredFilePath;
        } else {
            absoluteFilePath = Paths.get(System.getProperty("user.dir"), configuredFilePath).toAbsolutePath().toString();
        }
        
        generateTestCasePage.uploadScreenshot(absoluteFilePath);
    }

    @And("I click the \"Generate Test Case\" button on the screenshot page")
    public void iClickTheGenerateTestCaseButtonOnTheScreenshotPage() {
        generateTestCasePage.clickGenerateTestCaseButtonOnScreenshotPage();
    }

    @Then("the user should be redirected to generated test case view page")
    public void the_user_should_be_redirected_to_generated_test_case_view_page() {
        Assert.assertTrue(generateTestCasePage.isScreenshotTestCasesDisplayed(), "Screenshot test cases are not displayed after clicking on generate test case button.");
    }

}
