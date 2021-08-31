import org.junit.Test;
import org.openqa.selenium.By;


public class Task1 extends TestBase {

    @Test
    public void OpenGoogleAndSearch() {
        //comment for testing pushes
        driver.navigate().to("http://google.com");
        if (!driver.findElements(By.className("KxvlWc")).isEmpty())
            driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("test");
        driver.findElement(By.name("btnK")).click();
    }
}