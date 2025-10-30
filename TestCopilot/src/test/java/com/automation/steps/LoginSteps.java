package com.automation.steps;

import com.automation.pages.LoginPage;
import com.automation.pages.HomePage; 
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

public class LoginSteps {
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setupScenario() {
        DriverManager.initializeDriver("chrome"); 
        loginPage = new LoginPage(DriverManager.getDriver());
        homePage = new HomePage(DriverManager.getDriver());
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverManager.quitDriver();
    }
    
    
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        DriverManager.getDriver().get(ConfigReader.getProperty("base.url"));
    }

    @When("I enter a valid username and password")
    public void iEnterAValidUsernameAndPassword() {
        loginPage.enterEmail(ConfigReader.getProperty("valid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("valid.password"));
    }
    
    @When("I enter an invalid username and password")
    public void iEnterAnInvalidUsernameAndPassword() {
        loginPage.enterEmail(ConfigReader.getProperty("invalid.username"));
        loginPage.enterPassword(ConfigReader.getProperty("invalid.password"));
    }
    
    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page is not displayed after successful login.");
    }
    
    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed, or login button is not present.");
    }

    @And("I should remain on the login page")
    public void iShouldRemainOnTheLoginPage() {
    	Assert.assertFalse(homePage.isHomePageDisplayed(), "HomePage is not displayed after failed login.");
    }
}
