import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task10 extends TestBase {

    public int[] getRgbColor(String color) {
        String[] colorValue = color.replace("rgba(", "").replace(")", "").split(",");

        int r = Integer.parseInt(colorValue[0]);
        colorValue[1] = colorValue[1].trim();
        int g = Integer.parseInt(colorValue[1]);
        colorValue[2] = colorValue[2].trim();
        int b = Integer.parseInt(colorValue[2]);

        int[] rgbColor = new int[3];
        rgbColor[0] = r;
        rgbColor[1] = g;
        rgbColor[2] = b;

        return rgbColor;
    }

    public boolean isColorGray(String color) {
        int[] rgbColor = getRgbColor(color);

        if (rgbColor[0] == rgbColor[1] && rgbColor[1] == rgbColor[2]) {
            if (rgbColor[0] == 0) {
                return false;
            } else if (rgbColor[0] == 255)
                return false;
            else
                return true;
        }
        return false;
    }

    public boolean isColorRed(String color) {
        int[] rgbColor = getRgbColor(color);
        if (rgbColor[1] == 0 && rgbColor[2] == 0)
            return true;
        else
            return false;
    }

    public boolean isStrikeout(String cssValue) {
        String[] splittedCssValue = cssValue.split(" ");
        if (splittedCssValue[0].equals("line-through"))
            return true;
        else
            return false;
    }

    public boolean isBold(String cssValue) {
        if (cssValue.equals("bold"))
            return true;
        else if (Integer.parseInt(cssValue) >= 550)
            return true;
        else
            return false;
    }

    public boolean isBiggerFont(WebElement el1, WebElement el2) {

        double size1 = Double.parseDouble(el1.getCssValue("font-size").replaceAll("[px]", ""));
        double size2 = Double.parseDouble(el2.getCssValue("font-size").replaceAll("[px]", ""));

        if (size1 > size2)
            return true;
        else if (size1 == size2)
            return false;
        else
            return false;
    }

    @Test
    public void correctProductPage() {
        driver.get("http://localhost/litecart/en/");
        WebElement campaignProduct = driver.findElement(By.cssSelector("#box-campaigns div > ul > li"));
        String mainPageText = campaignProduct.findElement(By.cssSelector("div.name")).getText();

        WebElement mainPageRegularPrice = campaignProduct.findElement(By.cssSelector(".regular-price"));
        String mpRegularPriceText = mainPageRegularPrice.getText();
        String mpRpColor = mainPageRegularPrice.getCssValue("color");
        String mpRpTextDec = mainPageRegularPrice.getCssValue("text-decoration");

        WebElement mainPageCampaignPrice = campaignProduct.findElement(By.cssSelector(".campaign-price"));
        String mpCampaignPriceText = mainPageCampaignPrice.getText();
        String mpCColor = mainPageCampaignPrice.getCssValue("color");
        String mpCFontWeight = mainPageCampaignPrice.getCssValue("font-weight");

        assertTrue(isColorGray(mpRpColor));
        assertTrue(isStrikeout(mpRpTextDec));
        assertTrue(isColorRed(mpCColor));
        assertTrue(isBold(mpCFontWeight));
        assertTrue(isBiggerFont(mainPageCampaignPrice, mainPageRegularPrice));

        campaignProduct.click();

        WebElement productHeader = driver.findElement(By.tagName("h1"));
        String productHeaderText = productHeader.getText();

        WebElement productRegularPrice = driver.findElement(By.className("regular-price"));
        String productRegularPriceText = productRegularPrice.getText();
        String productRPColor = productRegularPrice.getCssValue("color");
        String productRPTextDec = productRegularPrice.getCssValue("text-decoration");

        WebElement productCampaignPrice = driver.findElement(By.className("campaign-price"));
        String productCampaignPriceText = productCampaignPrice.getText();
        String productCPColor = productCampaignPrice.getCssValue("color");
        String productCPFontWeight = productCampaignPrice.getCssValue("font-weight");


        assertEquals(mainPageText, productHeaderText);
        assertEquals(mpRegularPriceText, productRegularPriceText);
        assertEquals(mpCampaignPriceText, productCampaignPriceText);
        assertTrue(isColorGray(productRPColor));
        assertTrue(isStrikeout(productRPTextDec));
        assertTrue(isColorRed(productCPColor));
        assertTrue(isBold(productCPFontWeight));
        assertTrue(isBiggerFont(productCampaignPrice, productRegularPrice));
    }
}
