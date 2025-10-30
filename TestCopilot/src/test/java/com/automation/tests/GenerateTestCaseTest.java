package com.automation.tests;

import com.automation.pages.GenerateTestCasePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import org.testng.annotations.Test;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class GenerateTestCaseTest extends BaseTest {
    
	protected GenerateTestCasePage generatePage;
	private static final Logger logger = LogManager.getLogger(GenerateTestCaseTest.class);
	
    @Test
    public void verifyScreenshotUpload() {
        
        generatePage = new GenerateTestCasePage(driver);
        
        DriverManager.getDriver().get("https://www.testcopilot.testbuddy.io/login");
        
        LoginPage loginpage = new LoginPage(driver);
        String username = ConfigReader.getProperty("valid.username");
        String password = ConfigReader.getProperty("valid.password");
        loginpage.login(username, password);
        
        driver.findElement(By.xpath("//span[text()='Test Cases']")).click();
        driver.findElement(By.xpath("//span[text()='All Test Cases']")).click();
        driver.findElement(By.xpath("//span[text()='Generate Test Case']")).click();
        driver.findElement(By.xpath("//div[text()='Screenshot']")).click();
      
        String relativeFilePath = ConfigReader.getProperty("screenshot.file.path");
        String absoluteFilePath = Paths.get(System.getProperty("user.dir"), relativeFilePath).toAbsolutePath().toString();
        
        logger.info("Attempting to upload file from path: " + absoluteFilePath);

        generatePage.uploadScreenshot(absoluteFilePath);
        
    }
}
