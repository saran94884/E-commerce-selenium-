import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BestBuySelectBrand {
    public static void main(String[] args) {
         WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

        // Open Best Buy website
        driver.get("https://www.bestbuy.com/");

        // Hover over the "Brands" menu
        WebElement brandsMenu = driver.findElement(By.xpath("//button[@data-testid='header-tab-brands']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(brandsMenu).perform();

        // Click on a specific brand 
        WebElement appleBrand = driver.findElement(By.xpath("//a[@data-testid='brand-link' and contains(text(),'Apple')]"));
        appleBrand.click();

        // Click on a product from the brand's page 
        WebElement product = driver.findElement(By.xpath("//div[@class='sku-title']//a[contains(text(),'iPhone')]")); // Replace 'iPhone' with the product you want to select
        product.click();

        // Add the product to the shopping cart
        WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to Cart')]"));
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
