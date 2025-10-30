package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
 
public class TestRunExecutionPage extends BasePage {
	
	private final WebDriverWait wait;

    public TestRunExecutionPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        PageFactory.initElements(driver, this);
    }
    
    public void openTestRun(String testRunTitle) {
        By testRunTitleLink = By.xpath("//a[normalize-space()='" + testRunTitle + "']");
        wait.until(ExpectedConditions.elementToBeClickable(testRunTitleLink)).click();
    }
    
    public void openTestCase(String testCaseId) {
        By testCaseTitleLink = By.xpath("//td[normalize-space()='" + testCaseId + "']");
        wait.until(ExpectedConditions.elementToBeClickable(testCaseTitleLink)).click();
    }
    
   
    public void setTestCaseStatus() {
        By statusButton = By.xpath("//span[text()='Failed']");
        wait.until(ExpectedConditions.elementToBeClickable(statusButton)).click();
    }
    
 
    public void addDefect() {
    	By timeSpentInput = By.xpath("//input[@name='timeSpent']");
        wait.until(ExpectedConditions.elementToBeClickable(timeSpentInput)).sendKeys("1 Sec");
        By defectTitle = By.xpath("//input[@name='title']");
        wait.until(ExpectedConditions.elementToBeClickable(defectTitle)).sendKeys("Defect Title 1");
        By actualResult = By.xpath("//input[@name='actualResult']");
        wait.until(ExpectedConditions.elementToBeClickable(actualResult)).sendKeys("Actual Result 1");
        try {Thread.sleep(15000);} catch (InterruptedException e) {e.printStackTrace();}        
        WebElement assigneeDropdown = driver.findElement(By.xpath("//button[@id='assignee']"));
        wait.until(ExpectedConditions.visibilityOf(assigneeDropdown)).click();
        By selectAssignee = By.xpath("//div[@role='option']");
        wait.until(ExpectedConditions.elementToBeClickable(selectAssignee)).click();
        By addDefectButton = By.xpath("//button[text()='Add Defect']");
        wait.until(ExpectedConditions.elementToBeClickable(addDefectButton)).click();
        
    }
    public void setGlobalStatus() {
    	By globalStatusDrodown = By.xpath("//span[text()='Status:']/../div");
        wait.until(ExpectedConditions.elementToBeClickable(globalStatusDrodown)).click();
        By setGlobalStatus = By.xpath("//div[text()='Failed']");
        wait.until(ExpectedConditions.elementToBeClickable(setGlobalStatus)).click();
        //WebElement closeButton = driver.findElement(By.xpath("//button[@type='button'][contains(@class, 'lucide-x') or .//span[text()='Close']]"));
        WebElement closeButton = driver.findElement(By.xpath("//span[text()='Close']"));
        Actions a = new Actions(driver);
        a.scrollToElement(closeButton).build().perform();
        //wait.until(ExpectedConditions.visibilityOf(closeButton)).click();
    }
    
}