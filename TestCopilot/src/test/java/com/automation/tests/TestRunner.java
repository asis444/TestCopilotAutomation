package com.automation.tests;

import com.automation.utils.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.automation.utils.ExtentReportManager;

@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "com.automation.steps",           
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html", "json:target/cucumber-reports/cucumber.json"}, 
    monochrome = true, 
    tags = "@Login",
    		//or @GenerateTestCase or @GenerateTestCaseFromFigma or @GenerateTestCaseFromJira or @TestSuite or @CreateTestRun or @TestRunExecution
    dryRun = false                           
)
public class TestRunner extends AbstractTestNGCucumberTests {
    
    @BeforeSuite
    public void setupSuite() {
        ExtentReportManager.initializeReport();
    }
    
    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flushReport();
    }
}
