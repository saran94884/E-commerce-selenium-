import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuyAddToCart {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

        // Open Best Buy website
        driver.get("https://www.bestbuy.com/");

        // Search for an item
        WebElement searchBox = driver.findElement(By.id("gh-search-input"));
        searchBox.sendKeys("laptop"); // Change this to the item you want to search for
        searchBox.submit();

        // Click on the first search result
        WebElement firstSearchResult = driver.findElement(By.cssSelector("div.sku-title > a"));
        firstSearchResult.click();

        // Add the item to the shopping cart
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.add-to-cart-button"));
        addToCartButton.click();

        // Wait for the cart modal to appear
        try {
            Thread.sleep(2000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
