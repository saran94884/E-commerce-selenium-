import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuyCheckout {
    public static void main(String[] args) {
           WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

        // Open Best Buy website
        driver.get("https://www.bestbuy.com/");

        // Navigate to the checkout page
        WebElement cartIcon = driver.findElement(By.xpath("//button[@class='header-cart-button']"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//a[contains(text(),'Checkout')]"));
        checkoutButton.click();

        // Fill out the checkout form with dummy information
        WebElement firstNameInput = driver.findElement(By.id("user.firstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("user.lastName"));
        lastNameInput.sendKeys("Doe");

        WebElement phoneNumberInput = driver.findElement(By.id("user.phone"));
        phoneNumberInput.sendKeys("1234567890");

        WebElement emailInput = driver.findElement(By.id("user.email"));
        emailInput.sendKeys("john.doe@example.com");

        // Fill out the payment information
        WebElement cardNumberInput = driver.findElement(By.id("optimized-cc-card-number"));
        cardNumberInput.sendKeys("1234567890123456");

        WebElement expirationDateInput = driver.findElement(By.id("optimized-cc-exp"));
        expirationDateInput.sendKeys("12/25");

        WebElement cvvInput = driver.findElement(By.id("credit-card-cvv"));
        cvvInput.sendKeys("123");

        // Submit the form
        WebElement placeOrderButton = driver.findElement(By.xpath("//button[contains(text(),'Place Your Order')]"));
        placeOrderButton.click();

        // Wait for the order confirmation page to load
        try {
            Thread.sleep(5000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
