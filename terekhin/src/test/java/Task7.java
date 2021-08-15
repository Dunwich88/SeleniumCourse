import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Task7 extends TestBase {
    @Test
    public void clickAllMenuItems() {
        loginToAdminPanel();
        //Создание списка с элементами меню и получения его размера
        List<WebElement> menuItems = driver.findElements(By.id("app-"));
        int menuItemsSize = menuItems.size();

        //Цикл для прохода по всем элементам меню, начинается с единицы, т.к. nth-child начинается с 1
        for (int i = 1; i <= menuItemsSize; i++) {
            WebElement menuElement = menuElement = driver.findElement(By.cssSelector("#app-:nth-child(" + i + ")"));
            menuElement.findElement(By.tagName("a")).click();
            //Проверка на наличие пунктов подменю
            if (isElementPresent(By.cssSelector("#app- > ul"))) {
                    int submenuItemsSize = driver.findElements(By.cssSelector("#app-:nth-child(" + i + ") > ul > li")).size();
                    //Прокликивание пунктов подменю
                for (int j = 1; j <= submenuItemsSize; j++) {
                    WebElement submenuItem = driver.findElement(By.cssSelector("#app-:nth-child(" + i + ") > ul > li:nth-child(" + j + ")" ));
                    submenuItem.click();
                    //Проверка наличия заголовка на странице пункта подменю
                    assertTrue(isElementPresent(By.tagName("h1")));
                }
            }
            //Проверка наличия заголовка на странице пункта меню
            assertTrue(isElementPresent(By.tagName("h1")));
        }
    }
}

