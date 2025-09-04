package cucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PurchaseProductSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I launch the application")
    public void i_launch_the_application() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");
    }

    @When("I login with email {string} and password {string}")
    public void i_login_with_credentials(String email, String password) {
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();
    }

    @When("I add a product to the cart")
    public void i_add_a_product_to_the_cart() {
        WebElement products = driver.findElement(By.cssSelector(".card-body"));
        products.findElement(By.cssSelector(".btn.w-10")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
    }

    @When("I checkout the product")
    public void i_checkout_the_product() {
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        driver.findElement(By.cssSelector(".totalRow button")).click();
    }

    @When("I select country {string}")
    public void i_select_country(String country) {
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(country.substring(0, 4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ng-star-inserted")));

        List<WebElement> options = driver.findElements(By.cssSelector("span.ng-star-inserted"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(country)) {
                option.click();
                break;
            }
        }
    }

    @Then("I should be able to place the order successfully")
    public void i_should_be_able_to_place_the_order_successfully() {
        driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
        driver.quit();
    }
}
