package kene;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class xtentR {
    ExtentReports extent;

    @BeforeTest
    public void config() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("kene/the-mage.html");
        reporter.config().setReportName("Testing Report");
        reporter.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Kene");
    }
    @Test
    public void demo() {
        extent.createTest("demo");
        WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    String title = driver.getTitle();
    System.out.println(title);
    extent.flush();
    driver.close();



    }

}
