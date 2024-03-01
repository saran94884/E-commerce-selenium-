package actionLearning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.net.UrlChecker;

public class BrokenLinkValidator {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();

      
        String urlToValidate = "https://www.bestbuy.com/";


        driver.get(urlToValidate);


        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));


        for (WebElement link : links) {
            String linkUrl = link.getAttribute("href");
            if (linkUrl != null && !linkUrl.isEmpty()) {
                try {
                    UrlChecker.checkUrl(new java.net.URL(linkUrl), 5000);
                    System.out.println("Link " + linkUrl + " is valid.");
                } catch (java.net.MalformedURLException e) {
                    System.out.println("Malformed URL: " + linkUrl);
                } catch (java.io.IOException e) {
                    System.out.println("Link " + linkUrl + " is broken.");
                }
            }
        }

      
        driver.quit();
    }
}
