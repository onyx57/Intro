package kene;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    @Test(retryAnalyzer = RetryNG.class)
    public void purchaseProduct() {
        ChromeOptions options1s = new ChromeOptions();
        options1s.addArguments("headless");
        WebDriver driver = new ChromeDriver(options1s);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://rahulshettyacademy.com/client");

            driver.findElement(By.id("userEmail")).sendKeys("ktest@testt.com");
            driver.findElement(By.id("userPassword")).sendKeys("568956895689@xX");
            driver.findElement(By.id("login")).click();

            WebElement products = driver.findElement(By.cssSelector(".card-body"));
            products.findElement(By.cssSelector(".btn.w-10")).click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
            driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
            driver.findElement(By.cssSelector(".totalRow button")).click();

            driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Nige");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ng-star-inserted")));

            List<WebElement> options = driver.findElements(By.cssSelector("span.ng-star-inserted"));
            for (WebElement option : options) {
                if (option.getText().equalsIgnoreCase("Nigeria")) {
                    option.click();
                    break;
                }
            }
            driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();

        } finally {
            driver.quit();
        }
    }
}
