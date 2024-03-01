import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserClose {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
