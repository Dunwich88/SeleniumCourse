import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task17 extends TestBase{
    @Test
    public void browserLog() {
        loginToAdminPanel();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> linksToProducts = driver.findElements(By.cssSelector("tr:not(.header):not(.footer) > td:nth-child(3) > img + a"));
        for (int i = 0; i < linksToProducts.size(); i++) {
            linksToProducts = driver.findElements(By.cssSelector("tr:not(.header):not(.footer) > td:nth-child(3) > img + a"));
            linksToProducts.get(i).click();
            driver.findElement(By.name("cancel")).click();
        }
    }
}
