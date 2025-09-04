package kene;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    public static ExtentReports config() {

        ExtentSparkReporter reporter = new ExtentSparkReporter("kene/the-mage.html");
        reporter.config().setReportName("Testing Report");
        reporter.config().setDocumentTitle("Test Results");
        com.aventstack.extentreports.ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Kene");

        return extent;

    }
}
