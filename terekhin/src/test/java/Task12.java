import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class Task12 extends TestBase {
    String productNameValue = "test" + generateRandomNumber();
    String productCodeValue = "p" + generateRandomNumber();
    String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\shlepa.jpg";

    @Test
    public void addNewProduct() {
        loginToAdminPanel();
        WebElement catalogBtn = driver.findElement(By.cssSelector("#app-:nth-child(2)"));
        catalogBtn.click();

        WebElement addNewProductBtn = driver.findElement(By.cssSelector(".button:nth-child(2)"));
        addNewProductBtn.click();

        WebElement generalEnabledRadio = driver.findElement(By.name("status"));
        generalEnabledRadio.click();

        WebElement productName = driver.findElement(By.name("name[en]"));
        productName.sendKeys(productNameValue);

        WebElement productCode = driver.findElement(By.name("code"));
        productCode.sendKeys(productCodeValue);

        WebElement productQuantity = driver.findElement(By.name("quantity"));
        productQuantity.sendKeys("5");

        WebElement fileUploadBtn = driver.findElement(By.name("new_images[]"));
        fileUploadBtn.sendKeys(filePath);

        WebElement dateValidFrom = driver.findElement(By.name("date_valid_from"));
        dateValidFrom.sendKeys("01012021");

        WebElement dateValidTo = driver.findElement(By.name("date_valid_to"));
        dateValidTo.sendKeys("12122222");

        WebElement informationTab = driver.findElement(By.cssSelector(".index li:nth-child(2)"));
        informationTab.click();

        WebElement manafacturer = driver.findElement(By.name("manufacturer_id"));
        manafacturer.sendKeys("A");

        WebElement keywords = driver.findElement(By.name("keywords"));
        keywords.sendKeys("Test product");

        WebElement shortDecriprtion = driver.findElement(By.name("short_description[en]"));
        shortDecriprtion.sendKeys("Test short description");

        WebElement description = driver.findElement(By.cssSelector(".trumbowyg-editor"));
        description.sendKeys("Test description");

        WebElement pricesTab = driver.findElement(By.cssSelector(".index li:nth-child(4)"));
        pricesTab.click();

        WebElement purchasePrice = driver.findElement(By.name("purchase_price"));
        purchasePrice.sendKeys("11");

        WebElement priceUSD = driver.findElement(By.name("prices[USD]"));
        priceUSD.sendKeys("38");

        WebElement saveBtn = driver.findElement(By.name("save"));
        saveBtn.click();

        driver.findElement(By.id("doc-catalog")).click();

        assertTrue(isElementPresent(By.linkText(productNameValue)));


    }
}
