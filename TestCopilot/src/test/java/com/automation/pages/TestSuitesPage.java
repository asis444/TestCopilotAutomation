package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestSuitesPage extends BasePage {

    private final By createTestSuiteButton = By.xpath("//button[text()='Create Test Suite']");
    private final By testSuiteNameInput = By.xpath("//input[@placeholder='Enter suite name']"); 
    private final By saveButton = By.xpath("//button[text()='Create']");
    private final By testSuiteList = By.xpath("//div[@class='test-suite-list']"); 
    private final By addTestCaseButton = By.xpath("//button[text()='Add Test Case']"); 
    private final By testCaseSearchInput = By.xpath("//input[@placeholder='Search Test Case by Title/ID']");  
    private final By testCaseCheckbox = By.xpath("//button[@aria-label='Select all']");
    private final By addSelectedTestCasesButton = By.xpath("//button[text()='Add Selected']"); 

    public TestSuitesPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateTestSuiteButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(createTestSuiteButton))
                .click();
    }

    public void enterTestSuiteName(String suiteName) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(testSuiteNameInput))
                .sendKeys(suiteName);
    }

    public void clickSaveTestSuiteButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saveButton))
                .click();
    }


    public void addTestCaseToSuite() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addTestCaseButton))
                .click();
    }
    
    public void enterSearch(String testCaseTitle) {   
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(testCaseSearchInput))
                .sendKeys(testCaseTitle);
    }
    
    

	public void clickOnSelectAllCheckbox() {
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOfElementLocated(testCaseCheckbox)).click();
	}
	public void clickOnAddSelected() {
		//try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.visibilityOfElementLocated(addSelectedTestCasesButton)).click();
	}
		
	}


