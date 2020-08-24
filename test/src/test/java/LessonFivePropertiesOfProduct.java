import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;

import java.awt.*;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.Color.fromString;

public class LessonFivePropertiesOfProduct extends TestBase {
    @Test
    public void checkPropertiesOfProduct(){
        driver.get("http://localhost/litecart");

        //проверка свойств элементов на главной
        WebElement itemOfProduct = driver.findElement(By.cssSelector("#box-campaigns .product:first-child"));
        String nameMain = itemOfProduct.findElement(By.cssSelector(".name")).getText();
        String regularPriceMain = itemOfProduct.findElement(By.cssSelector(".regular-price")).getText();
        String campaignPriceMain = itemOfProduct.findElement(By.cssSelector(".campaign-price")).getText();

        String colorRegular = itemOfProduct.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        colorRegular = colorRegular.replaceAll("[rgba()]", "");
        String[] colorReg = colorRegular.split(",");
        assertTrue(colorReg[0].equals(colorReg[1].substring(1)) & colorReg[1].substring(1).equals(colorReg[2].substring(1)));

        String textDecorationRegular = itemOfProduct.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        assertTrue(textDecorationRegular.contains("line-through"));

        String colorCampaign = itemOfProduct.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        colorCampaign = colorCampaign.replaceAll("[rgba()]", "");
        String[] colorCamp = colorCampaign.split(",");
        assertTrue(colorCamp[1].equals(" 0") & colorCamp[2].equals(" 0"));

        String textDecorationCampaign = itemOfProduct.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
        assertTrue(textDecorationCampaign.contains("00"));

        String sizePriceRegular = itemOfProduct.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        String sizePriceCampaign = itemOfProduct.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        assertTrue(Float.parseFloat(sizePriceCampaign.substring(0, sizePriceCampaign.length()-2)) > Float.parseFloat(sizePriceRegular.substring(0, sizePriceRegular.length()-2)));

        //проверка свойств элементов на странице продукта
        itemOfProduct.click();

        String nameProduct = driver.findElement(By.cssSelector("h1")).getText();
        assertTrue(nameMain.equals(nameProduct));

        String regularPriceProduct = driver.findElement(By.cssSelector(".regular-price")).getText();
        assertTrue(regularPriceMain.equals(regularPriceProduct));

        String campaignPriceProduct = driver.findElement(By.cssSelector(".campaign-price")).getText();
        assertTrue(campaignPriceMain.equals(campaignPriceProduct));

        colorRegular = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        colorRegular = colorRegular.replaceAll("[rgba()]", "");
        colorReg = colorRegular.split(",");
        assertTrue(colorReg[0].equals(colorReg[1].substring(1)) & colorReg[1].substring(1).equals(colorReg[2].substring(1)));


        textDecorationRegular = driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        assertTrue(textDecorationRegular.contains("line-through"));

        colorCampaign = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        colorCampaign = colorCampaign.replaceAll("[rgba()]", "");
        colorCamp = colorCampaign.split(",");
        assertTrue(colorCamp[1].equals(" 0") & colorCamp[2].equals(" 0"));

        textDecorationCampaign = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
        assertTrue(textDecorationCampaign.contains("700"));

        sizePriceRegular = driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");
        sizePriceCampaign = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");
        assertTrue(Float.parseFloat(sizePriceCampaign.substring(0, sizePriceCampaign.length()-2)) > Float.parseFloat(sizePriceRegular.substring(0, sizePriceRegular.length()-2)));

    }

}
