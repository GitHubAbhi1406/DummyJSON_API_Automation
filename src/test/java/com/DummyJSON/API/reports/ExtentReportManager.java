package com.DummyJSON.API.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager{
	private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {
            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("reports/DummyJSON_API_Report.html");

            reporter.config().setReportName("DummyJSON API Automation Report");
            reporter.config().setDocumentTitle("API Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
