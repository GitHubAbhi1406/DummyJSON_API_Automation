package com.DummyJSON.API.listeners;

import org.testng.*;
import com.aventstack.extentreports.*;
import com.DummyJSON.API.reports.ExtentReportManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentReportManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // SAVE BUTTON
    }
}
