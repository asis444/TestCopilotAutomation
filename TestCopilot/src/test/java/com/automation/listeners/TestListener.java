package com.automation.listeners;

import com.automation.utils.ExtentReportManager;
import com.automation.utils.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("=== Test Started: " + result.getMethod().getMethodName() + " ===");
        ExtentReportManager.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("=== Test Passed: " + result.getMethod().getMethodName() + " ===");
        ExtentReportManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("=== Test Failed: " + result.getMethod().getMethodName() + " ===");
        
        // Add a null check before attempting to get the test instance
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().fail("Test failed: " + result.getThrowable());

            if (DriverManager.getDriver() != null) {
                TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
                File screenshot = ts.getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String screenshotName = result.getMethod().getMethodName() + "_" + timestamp + ".png";
                Path screenshotPath = Paths.get("test-output", screenshotName);

                try {
                    Files.createDirectories(screenshotPath.getParent());
                    Files.move(screenshot.toPath(), screenshotPath);
                    ExtentReportManager.getTest().fail("Screenshot on failure",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath.toString()).build());
                } catch (IOException e) {
                    logger.error("Failed to take screenshot: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (ExtentReportManager.getTest() != null) {
            logger.warn("=== Test Skipped: " + result.getMethod().getMethodName() + " ===");
            ExtentReportManager.getTest().log(Status.SKIP, "Test skipped");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("=== Test Suite Started: " + context.getSuite().getName() + " ===");
        ExtentReportManager.initializeReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("=== Test Suite Completed: " + context.getSuite().getName() + " ===");
        ExtentReportManager.flushReport();
    }
}
