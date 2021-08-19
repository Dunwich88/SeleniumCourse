import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Task11 extends TestBase {
    String firstName = "firstName";
    String lastName = "lastName";
    String address1 = "address1";
    String postcode = "12345";
    String city = "Odessa";
    String phoneNumber = "2025550195";
    String password = "Qwerty123!";
    String email = "email" + generateRandomNumber() + "@email.com";

    @Test
    public void createNewUser() {
        String selectUsaScript = "arguments[0].selectedIndex = 224; arguments[0].dispatchEvent(new Event('change'))";

        driver.get("http://localhost/litecart/en/");
        WebElement newCustomerLink = driver.findElement(By.cssSelector("table > tbody > tr:nth-child(5) a"));
        newCustomerLink.click();

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        WebElement address1Input = driver.findElement(By.name("address1"));
        WebElement postcodeInput = driver.findElement(By.name("postcode"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement countryInput = driver.findElement(By.cssSelector("select"));
        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement phoneInput = driver.findElement(By.name("phone"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement confirmedPasswordInput = driver.findElement(By.name("confirmed_password"));
        WebElement createAccountBtn = driver.findElement(By.name("create_account"));

        jsExecutor(countryInput, selectUsaScript);
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        address1Input.sendKeys(address1);
        postcodeInput.sendKeys(postcode);
        cityInput.sendKeys(city);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phoneNumber);
        passwordInput.sendKeys(password);
        confirmedPasswordInput.sendKeys(password);
        createAccountBtn.click();

        driver.findElement(By.linkText("Logout")).click();

        WebElement loginEmailAddress = driver.findElement(By.name("email"));
        WebElement loginPassword = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.name("login"));

        loginEmailAddress.sendKeys(email);
        loginPassword.sendKeys(password);
        loginBtn.click();

        driver.findElement(By.linkText("Logout")).click();
    }
}
