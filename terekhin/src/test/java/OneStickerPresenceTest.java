import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class OneStickerPresenceTest extends TestBase {
    @Test
    public void checkStickersPresece() {
        driver.get("http://localhost/litecart/en/");
        //Формируем список товаров
        List<WebElement> products = driver.findElements(By.className("product"));
        //Идем по сформированному списку и для каждого товара проверяем наличие только одного стикера
        for (WebElement we: products) {
            assertTrue(we.findElements(By.className("sticker")).size() == 1);
        }
    }
}
