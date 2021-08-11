import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CheckHeaderForEachMenuItem extends TestBase {
    @Test
    public void loginToAdmin() {
        driver.get("http://localhost/litecart/admin/login.php");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.name("login"));

        username.click();
        username.sendKeys("admin");

        password.click();
        password.sendKeys("admin");

        loginBtn.click();
    }

    @Test
    public void clickAllMenuItems() {
        loginToAdmin();
        List<WebElement> menuItems = driver.findElements(By.id("app-"));
        int menuItemsSize = menuItems.size();

        for (int i = 0; i < menuItemsSize; i++) {
            driver.findElement(By.cssSelector("#box-apps-menu:nth-child(" + i + ")")).click();
        }
    }
}

