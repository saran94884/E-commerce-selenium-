import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BestBuyShopByDepartment {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();


        // Open Best Buy website
        driver.get("https://www.bestbuy.com/");

        // Hover over the "Shop by Department" menu
        WebElement shopByDepartmentMenu = driver.findElement(By.xpath("//button[@class='header-tab__button']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shopByDepartmentMenu).perform();

        // Click on a specific department 
        WebElement computersTabletsDept = driver.findElement(By.xpath("//a[contains(text(),'Computers & Tablets')]"));
        computersTabletsDept.click();

        // Click on a subcategory or item 
        WebElement laptopsCategory = driver.findElement(By.xpath("//a[contains(text(),'Laptops')]"));
        laptopsCategory.click();

        // Click on a specific item
        WebElement item = driver.findElement(By.xpath("//div[@class='sku-title']//a[contains(text(),'Macbook')]"));
        item.click();

        // Add the item to the shopping cart
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
