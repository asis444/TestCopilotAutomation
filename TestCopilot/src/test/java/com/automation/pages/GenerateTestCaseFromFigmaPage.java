package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GenerateTestCaseFromFigmaPage extends BasePage {

    private final String figmaApiToken = ConfigReader.getProperty("valid.apiToken");
    private final String figmaFileKey = ConfigReader.getProperty("valid.fileKey");
    private final WebDriverWait wait;

    private final By figmaApiTokenDropdown = By.xpath("//input[@name='figmaAccessToken']");
    private final By figmaFileKeyInput = By.xpath("//input[@name='figmaFileKey']");
    private final By fetchPagesButton = By.xpath("//button[text()='Fetch Pages']");
    private final By pagesSidebar = By.xpath("//div[@class='flex flex-col items-center']");
    private final By frameName = By.xpath("//button[contains(., 'Login / Register Screens')]");
    private final By generateTestCasesButton = By.xpath("(//button[@data-slot='button' and contains(., 'Test Cases')])[2]");
    private final By successMessage = By.xpath("//div[text()='Test cases loaded successfully']");
    private final By generatedTestCasesContainer = By.xpath("//h2[text()='Test Cases']");
    private final By errorMessage = By.xpath("//div[contains(@class, 'message-box') and contains(text(), 'Error')]");

    public GenerateTestCaseFromFigmaPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToPage() {
        driver.get("https://www.testcopilot.io/figma-auth");
        wait.until(ExpectedConditions.urlContains("/figma-auth"));
    }

    public void enterValidCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(figmaApiTokenDropdown)).sendKeys(figmaApiToken);
        wait.until(ExpectedConditions.visibilityOfElementLocated(figmaFileKeyInput)).sendKeys(figmaFileKey);
    }
    
    public void enterInvalidCredentials() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(figmaApiTokenDropdown)).sendKeys("invalid_token");
        wait.until(ExpectedConditions.visibilityOfElementLocated(figmaFileKeyInput)).sendKeys("invalid_key");
    }
    
    public void clickFetchPages() {
        wait.until(ExpectedConditions.elementToBeClickable(fetchPagesButton)).click();
    }
    
    public void waitForPagesSidebar() {
    	wait.until(ExpectedConditions.urlContains("/figma-frames"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pagesSidebar));
    }
    
    public void clickSidebarPage(String pageName) {
        wait.until(ExpectedConditions.elementToBeClickable(frameName)).click();
    }
    
    
    public void hoverOverFrame(String frameName) {
        WebElement frameElement = driver.findElement(By.xpath("//span[text()='Register']"));
        Actions a = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(frameElement));
        a.moveToElement(frameElement).build().perform();
    }

    public void clickGenerateTestCases() {
        wait.until(ExpectedConditions.elementToBeClickable(generateTestCasesButton)).click();
    }
    
    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }

    public boolean areGeneratedTestCasesVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(generatedTestCasesContainer)).isDisplayed();
    }
    
    public boolean isErrorMessageDisplayed(String message) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText().contains(message);
    }
}
