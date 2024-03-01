import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BestBuySignUpLogin {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();



        driver.get("https://www.bestbuy.com/");

        
        WebElement accountLink = driver.findElement(By.className("account"));
        accountLink.click();

        // Sign-Up
        // Find and click on the "Create Account" button
        WebElement createAccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
        createAccountButton.click();

        // Fill in the sign-up form
        WebElement signUpEmailInput = driver.findElement(By.id("fld-e"));
        signUpEmailInput.sendKeys("your_email@example.com");

        WebElement signUpPasswordInput = driver.findElement(By.id("fld-p1"));
        signUpPasswordInput.sendKeys("your_password");

        // Submit the sign-up form
        WebElement signUpSubmitButton = driver.findElement(By.xpath("//button[contains(text(),'Create Account')]"));
        signUpSubmitButton.click();

        // Login
        // Find and click on the "Sign In" link
        WebElement signInLink = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        signInLink.click();

        // Fill in the login form
        WebElement loginEmailInput = driver.findElement(By.id("fld-e"));
        loginEmailInput.sendKeys("saran@gmail.com");

        WebElement loginPasswordInput = driver.findElement(By.id("fld-p1"));
        loginPasswordInput.sendKeys("saran456");

        // Submit the login form
        WebElement loginSubmitButton = driver.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
        loginSubmitButton.click();

        // Close the browser
        driver.quit();
    }
}
