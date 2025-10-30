package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private final By welcomeText = By.xpath("//h2[text()='Dashboard']");
    private final By TestCasesLink = By.xpath("//span[text()='Test Cases']"); 
    private final By allTestCasesLink = By.xpath("//span[text()='All Test Cases']");
    private final By generateTestCaseButton = By.xpath("//span[text()='Generate Test Case']");
    private final By screenshotOption = By.xpath("//div[text()='Screenshot']");
    private final By FigmaOption = By.xpath("//div[text()='Figma Design']");
    private final By JiraOption = By.xpath("//div[text()='Jira']");
    private final By testSuiteButton = By.xpath("//span[text()='Test Suites']");

    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(welcomeText));
            return true;
        } catch (Exception e) {
            return false;	
        }
    }
    
    public void navigateToAllTestCases() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(TestCasesLink))
                .click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(allTestCasesLink))
        .click();
    }

    public void clickGenerateTestCaseButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(generateTestCaseButton))
                .click();
    }

    public void selectScreenshotGenerationOption() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(screenshotOption))
                .click();
    }

	public void navigateToTestSuites() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(testSuiteButton))
        .click();
	}

	public void selectFigmaGenerationOption() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(FigmaOption))
        .click();		
	}
	public void selectJiraGenerationOption() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(JiraOption))
		.click();		
	}
    
}
