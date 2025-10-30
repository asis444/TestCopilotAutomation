package com.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestPlanPage extends BasePage {

    private WebDriverWait wait;

    private By TestPlanButton = By.xpath("//span[text()='Test Plan']");
    private By createTestPlanButton = By.xpath("//button[contains(text(), 'Create Test Plan')]");
    private By testPlanTitleInput = By.cssSelector("input[placeholder='Enter test plan title']");
    private By startDateInput = By.cssSelector("input[name='Start Date']");
    private By endDateInput = By.cssSelector("input[name='End Date']");
    private By descriptionTextarea = By.cssSelector("textarea[placeholder='Enter a description...']");
    private By createButtonInModal = By.xpath("//div[@role='dialog']//button[contains(text(), 'Create')]");
    private By successMessage = By.xpath("//div[contains(text(), 'Test Plan created successfully.')]");

    public TestPlanPage(WebDriver driver) {
    	super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickCreateTestPlan() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createTestPlanButton));
        button.click();
    }

    public void fillTestPlanForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(testPlanTitleInput)).sendKeys();
        driver.findElement(startDateInput).sendKeys();
        driver.findElement(endDateInput).sendKeys();
        driver.findElement(descriptionTextarea).sendKeys();
    }

    public void clickCreateButtonInModal() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(createButtonInModal));
        button.click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	public void navigateToTestPlan() {
		
	}
}
