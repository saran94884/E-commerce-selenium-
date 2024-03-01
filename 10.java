import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuyOrderConfirmation {
    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();


        // Open the order confirmation page (replace "order_confirmation_page_url" with the actual URL)
        driver.get("order_confirmation_page_url");

        // Find the order confirmation message element
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[contains(@class,'order-confirmation-message')]"));

        // Verify if the confirmation message is displayed
        if (confirmationMessage.isDisplayed()) {
            System.out.println("Order was placed successfully.");
        } else {
            System.out.println("Order confirmation message not found. Order might not have been placed successfully.");
        }

        // Close the browser
        driver.quit();
    }
}
