import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task13 extends TestBase {
    @Test
    public void basketActions() {
        for (int i = 0; i < 3; i++) {
            driver.get("http://localhost/litecart/en/");
            WebElement product = driver.findElement(By.className("product"));
            product.click();

            WebElement addToCartBtn = driver.findElement(By.name("add_cart_product"));

            if (isElementPresent(By.name("options[Size]")))
            {
                Actions builder = new Actions(driver);
                Action selectSecondOption = builder.moveToElement(driver.findElement(By.name("options[Size]"))).click().
                        sendKeys(Keys.DOWN).
                        sendKeys(Keys.RETURN).
                        build();
                selectSecondOption.perform();
            }
            addToCartBtn.click();
            assertTrue(wait.until(ExpectedConditions.textToBe(By.className("quantity"), String.valueOf(i + 1))));
        }
        WebElement cartLink = driver.findElement(By.cssSelector("#cart br ~ a"));
        cartLink.click();

        List<WebElement> summaryItems = driver.findElements(By.cssSelector("#order_confirmation-wrapper > table > tbody > tr:not(.header):not(.footer)"));

        while (isElementPresent(By.name("remove_cart_item")))
        {
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(summaryItems.get(0)));
        }
    }
}