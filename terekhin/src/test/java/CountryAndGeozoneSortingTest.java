import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CountryAndGeozoneSortingTest extends TestBase {

    public int getZonesNumber(WebElement webElement) {
        return Integer.parseInt(webElement.getAttribute("outerText"));
    }

    @Test
    public void CountrySorting() {
        loginToAdminPanel();
        WebElement countryBtn = driver.findElement(By.cssSelector("#app-:nth-child(3)"));
        countryBtn.click();
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row"));
        List<String> countryText = new LinkedList<>();
        for (WebElement co: countries) {
            WebElement countryLink = co.findElement(By.cssSelector("td:nth-child(5) > a"));
            countryText.add(countryLink.getAttribute("outerText"));
            }
        assertTrue(isSorted(countryText));
        }

    @Test
    public void geozoneInCountriesSorting() {
        loginToAdminPanel();
        WebElement countryBtn = driver.findElement(By.cssSelector("#app-:nth-child(3)"));
        countryBtn.click();
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row"));
        int countrySize = countries.size();
        for (int i = 2; i <= countrySize; i++) {
            WebElement country = driver.findElement(By.cssSelector("tr:nth-child(" + i + ")"));
            int zonesNumber = getZonesNumber(country.findElement(By.cssSelector("td:nth-child(6)")));
            if (zonesNumber != 0) {
                country.findElement(By.cssSelector("a")).click();
                List<WebElement> zonesList = driver.findElements(By.cssSelector("#table-zones td:nth-child(3)"));
                List<String> zonesText = new LinkedList<>();
                for (WebElement zoTe: zonesList) {
                    if (zoTe.getAttribute("outerText").equals(""))
                        break;
                    zonesText.add(zoTe.getAttribute("outerText"));
                }
                assertTrue(isSorted(zonesText));
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
            }
        }
        }

        @Test
        public void geozonesSorting() {
            loginToAdminPanel();
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            int countriesSize = driver.findElements(By.cssSelector("#content > form > table > tbody > tr:not(.header):not(.footer)")).size();
            for (int i = 1; i <= countriesSize ; i++) {
                WebElement geozone = driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child("+ (i+1) + ") > td:nth-child(3) > a"));
                geozone.click();
                String disabled = driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3) > select")).getAttribute("disabled");
                if (disabled == null) {
                    List<WebElement> geozoneDropDowns = driver.findElements(By.cssSelector("select:not(.select2-hidden-accessible) > option[selected=selected]"));
                    List<String> geozoneDropDownsText = new LinkedList<>();
                    for (WebElement gzDd : geozoneDropDowns) {
                        geozoneDropDownsText.add(gzDd.getAttribute("outerText"));
                    }
                    assertTrue(isSorted(geozoneDropDownsText));
                    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
                }
                else {
                    List<WebElement> geozoneDropDowns = driver.findElements(By.cssSelector("td > span.select2"));
                    List<String> geozoneDropDownsText = new LinkedList<>();
                    for (WebElement gzDd : geozoneDropDowns) {
                        geozoneDropDownsText.add(gzDd.getAttribute("outerText"));
                    }
                    assertTrue(isSorted(geozoneDropDownsText));
                    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
                }
            }

        }
    }
