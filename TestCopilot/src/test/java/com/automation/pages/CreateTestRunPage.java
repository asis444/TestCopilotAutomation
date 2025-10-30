package com.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Assuming you have a BasePage class with common methods like getDriver(), etc.
public class CreateTestRunPage extends BasePage {

    private final WebDriverWait wait;

    private final By testRunNavLink = By.xpath("//span[text()='Test Run']");
    private final By createTestRunButton = By.xpath("//button[text()='Create Test Run']");
    private final By titleInput = By.xpath("//input[@placeholder='Enter test run title']");
    private final By addTestCasesButton = By.xpath("(//button[@type='button'])[4]");
    private final By configurationSelectButton = By.xpath("//input[@placeholder='Select configurations']");
    private final By configurationSelect = By.xpath("//button[text()='Windows 10']");
    private final By stateSelectButton = By.xpath("//input[@placeholder='Select state']");
    private final By stateSelect = By.xpath("//button[text()='active']");
    private final By createButton = By.xpath("//button[text()='Create']");
    private final By selectTestCase = By.xpath("(//tbody)[2]/tr/td/button[1]");
    private final By assignToRunButton = By.xpath("//button[text()='Assign to Run']");

    public CreateTestRunPage(WebDriver driver) {
    	super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToTestRun() {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(testRunNavLink)).click();
    }
    
    public void clickCreateTestRunButton() {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(createTestRunButton)).click();
      }
    
    public void enterRunTitle(String title) {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(titleInput)).sendKeys(title);
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(configurationSelectButton)).click();
    	new WebDriverWait(driver, Duration.ofSeconds(10))
    	.until(ExpectedConditions.elementToBeClickable(configurationSelect)).click();
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(stateSelectButton)).click();
    	new WebDriverWait(driver, Duration.ofSeconds(10))
    	.until(ExpectedConditions.elementToBeClickable(stateSelect)).click();
      }
    
    public void clickAddTestCases() {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(addTestCasesButton)).click();
  
    }

    public void selectTestCase() {
    	try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
    	new WebDriverWait(driver, Duration.ofSeconds(60))
        .until(ExpectedConditions.elementToBeClickable(selectTestCase)).click();
  
    }
    
    public void clickAssignToRun() {
    	new WebDriverWait(driver, Duration.ofSeconds(20))
        .until(ExpectedConditions.elementToBeClickable(assignToRunButton)).click();
      }
    
    
    public void clickCreateButton() {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
    	.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }
    
}
