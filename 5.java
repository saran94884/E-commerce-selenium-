import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class BestBuyBottomLinksValidation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

        // Open Best Buy website
        driver.get("https://www.bestbuy.com/");

        // Scroll to the bottom of the page to load all the elements
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Find all bottom links
        List<WebElement> bottomLinks = driver.findElements(By.xpath("//footer//a"));

        // Validate each bottom link
        for (WebElement bottomLink : bottomLinks) {
            String linkUrl = bottomLink.getAttribute("href");
            String linkText = bottomLink.getText();
            System.out.println("Validating link: " + linkText + " - " + linkUrl);

            // Check if the link URL is not empty and is a valid URL
            if (linkUrl != null && !linkUrl.isEmpty()) {
                bottomLink.click(); // Click the link to navigate

                // Wait for the page to load
                try {
                    Thread.sleep(2000); // Adjust the sleep time as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Get the current URL after navigation
                String currentUrl = driver.getCurrentUrl();

                // Validate if the current URL matches the expected link URL
                if (currentUrl.equals(linkUrl)) {
                    System.out.println("Link is valid.");
                } else {
                    System.out.println("Link is broken or redirected to a different page.");
                }

                // Go back to the homepage for the next iteration
                driver.get("https://www.bestbuy.com/");
            } else {
                System.out.println("Link URL is empty or invalid.");
            }
        }

        // Close the browser
        driver.quit();
    }
}
