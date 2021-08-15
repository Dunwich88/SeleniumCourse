import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginToAdmin extends TestBase {

    @Test
    @Override
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
}
