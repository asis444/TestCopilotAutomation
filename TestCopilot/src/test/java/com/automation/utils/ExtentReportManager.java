package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void initializeReport() {
        if (extentReports == null) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
            String reportPath = "test-output/ExtentReport_" + timestamp + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setReportName("Test Execution Report");
            sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);
            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }
    }

    public static ExtentTest createTest(String testName, String testDescription) {
        ExtentTest test = extentReports.createTest(testName, testDescription);
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }
    
    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    public static void logInfo(String message) {
        getTest().info(message);
    }
}
