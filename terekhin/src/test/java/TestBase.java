import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    boolean areElementsPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public static boolean isSorted(List<String> listOfStrings) {
        if ((listOfStrings == null && listOfStrings.isEmpty()) || listOfStrings.size() == 1) {
            return true;
        }

        Iterator<String> iter = listOfStrings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public void loginToAdminPanel() {
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

    @Before
    public void start() {
        if (tlDriver.get() != null) {
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        tlDriver.set(driver);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        wait = new WebDriverWait(driver, 10);

//        Runtime.getRuntime().addShutdownHook(
//                new Thread(() -> {driver.quit(); driver = null;}));
    }

    @After
    public void stop() {
//        driver.quit();
//        driver = null;
    }

}
