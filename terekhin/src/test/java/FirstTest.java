import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void OpenGoogleAndSearch() {
        driver.get("http://google.com");
        if (!driver.findElements(By.className("KxvlWc")).isEmpty())
            driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("test");
        driver.findElement(By.name("btnK")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}