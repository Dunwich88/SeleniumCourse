import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToAdmin {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void loginToAdminPanel() {
        driver.get("https://localhost/litecart/admin/login.php");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.name("login"));

        username.click();
        username.sendKeys("admin");

        password.click();
        password.sendKeys("admin");

        loginBtn.click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
