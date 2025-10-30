package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenerateTestCaseFromJiraPage extends BasePage {

    private final WebDriverWait wait;
    
    String hostUrl = ConfigReader.getProperty("jira.host.url");
    String email = ConfigReader.getProperty("jira.user.email");
    String apiToken = ConfigReader.getProperty("jira.api.token");
    

    private final By jiraHostUrlInput = By.xpath("//input[@placeholder='Enter Host URL']");
    private final By userEmailInput = By.xpath("//input[@placeholder='Enter User Email']");
    private final By apiTokenInput = By.xpath("//input[@placeholder='Enter Api Token']");
    private final By jiraOption = By.xpath("//div[contains(@class, 'dropdown-menu')]//*[text()='Jira']");
    private final By continueToNextButton = By.xpath("//button[@type='submit']");
    private final By projectName = By.xpath("//option[text()='TestBuddy Co-Pilot (TBCO)']");
    private final By userStories = By.xpath("(//div[.//span[contains(text(), 'TBCO-948')]])[4]");

    // Locators for the Project and User Stories page (Screenshot 2 & 3)
    private final By projectDropdown = By.xpath("//button[.//span[text()='Select Jira Project']]");
    private final By userStoriesDropdown = By.xpath("//span[text()='Select User Stories']");
    private final By generateTestCasesButton = By.xpath("//button[text()='Generate Test Cases']");

    // Locators for the results page (Screenshot 4)
    private final By testCasesList = By.xpath("//div[contains(@class, 'test-case-list')]");
    private final By successMessage = By.xpath("//div[contains(@class, 'message-box') and contains(text(), 'Test cases generated successfully!')]");


    public GenerateTestCaseFromJiraPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * Navigates to the Jira test case generator from the 'All Test Cases' page.
     */
    public void startJiraTestGenerationFlow() {
        wait.until(ExpectedConditions.elementToBeClickable(jiraOption)).click();
        wait.until(ExpectedConditions.urlContains("/jira-auth"));
    }

    /**
     * Enters the Jira authentication details.
     * @param hostUrl The Jira host URL.
     * @param email The user's email.
     * @param apiToken The Jira API token.
     */
    public void enterJiraAuthDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(jiraHostUrlInput)).sendKeys(hostUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(apiTokenInput)).sendKeys(apiToken);
    }

    public void clickOnContinue() {
    	wait.until(ExpectedConditions.elementToBeClickable(continueToNextButton)).click();
            }
    public void clickOnContinueSecond() {
    	wait.until(ExpectedConditions.elementToBeClickable(continueToNextButton)).click();
    }
    /**
     * Selects a project and a list of user stories.
     * @param projectName The name of the project to select from the dropdown.
     * @param userStories A comma-separated string of user stories to select.
     */
    public void selectProjectAndUserStories() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(projectName)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userStoriesDropdown)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userStories)).click();
       
    }
    
    /**
     * Clicks the button to generate test cases after all selections are made.
     */
    public void clickGenerateTestCasesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(generateTestCasesButton)).click();
    }
    
    /**
     * Verifies that the test cases are displayed successfully.
     * @return True if the test case list is visible, false otherwise.
     */
    public boolean areTestCasesDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesList)).isDisplayed();
    }

    /**
     * Verifies if the success message is displayed.
     * @return True if the success message is displayed, false otherwise.
     */
    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

}
