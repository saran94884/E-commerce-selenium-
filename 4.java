import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BestBuyMenuNavigation {
    public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();




        // Open Best Buy website
        driver.get("https://www.bestbuy.com/");

        // Find all menu items
        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[contains(@class,'flyout-menu')]//a"));

        // Navigate through each menu item
        for (WebElement menuItem : menuItems) {
            // Click on the menu item
            menuItem.click();

            // Wait for the page to load
            try {
                Thread.sleep(2000); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Get the title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Validate the title of the page
            // You can implement your validation logic here
            // For simplicity, let's just print if the title is not empty
            if (!pageTitle.isEmpty()) {
                System.out.println("Title is valid.");
            } else {
                System.out.println("Title is not valid.");
            }

            // Go back to the homepage for the next iteration
            driver.get("https://www.bestbuy.com/");
        }

        // Close the browser
        driver.quit();
    }
}
