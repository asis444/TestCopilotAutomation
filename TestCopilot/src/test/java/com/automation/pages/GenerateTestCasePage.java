package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class GenerateTestCasePage extends BasePage {

    private final By fileUploadInput = By.xpath("//input[@type='file']");
    private final By generateTestCaseButton = By.xpath("//button[text()='Generate Test Case']");
    private final By screenshotTestCasePage = By.xpath("//h2[text()='Screenshot Test Cases']");
    
    public GenerateTestCasePage(WebDriver driver) {
        super(driver);
    }


    public void uploadScreenshot(String filePath) {
        driver.findElement(fileUploadInput).sendKeys(filePath);
    }


	public void clickGenerateTestCaseButtonOnScreenshotPage() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(generateTestCaseButton))
        .click();
	}


	public boolean isScreenshotTestCasesDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(50))
                    .until(ExpectedConditions.visibilityOfElementLocated(screenshotTestCasePage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}