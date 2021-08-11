import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest extends TestBase {

    @Test
    public void OpenGoogleAndSearch() {
        driver.navigate().to("http://google.com");
        if (!driver.findElements(By.className("KxvlWc")).isEmpty())
            driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("test");
        driver.findElement(By.name("btnK")).click();
    }
}