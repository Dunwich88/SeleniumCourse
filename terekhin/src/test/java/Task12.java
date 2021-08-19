import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task12 extends TestBase {
    @Test
    public void addNewProduct() {
        loginToAdminPanel();
        WebElement catalogBtn = driver.findElement(By.cssSelector("#app-:nth-child(2)"));
        catalogBtn.click();

        WebElement addNewProductBtn = driver.findElement(By.cssSelector(".button:nth-child(2)"));
        addNewProductBtn.click();
    }
}
