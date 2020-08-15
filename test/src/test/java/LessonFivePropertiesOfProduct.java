import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

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
        assertTrue(colorRegular.contains("119, 119, 119"));

        String textDecorationRegular = itemOfProduct.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        assertTrue(textDecorationRegular.contains("line-through"));

        String colorCampaign = itemOfProduct.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        assertTrue(colorCampaign.contains("204, 0, 0"));

        String textDecorationCampaign = itemOfProduct.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
        assertTrue(textDecorationCampaign.contains("00"));

        int sizePriceRegular = Integer.parseInt(itemOfProduct.findElement(By.cssSelector(".regular-price")).getAttribute("offsetHeight"));
        int sizePriceCampaign = Integer.parseInt(itemOfProduct.findElement(By.cssSelector(".campaign-price")).getAttribute("offsetHeight"));
        assertTrue(sizePriceCampaign > sizePriceRegular);

        //проверка свойств элементов на странице продукта
        itemOfProduct.click();

        String nameProduct = driver.findElement(By.cssSelector("h1")).getText();
        assertTrue(nameMain.equals(nameProduct));

        String regularPriceProduct = driver.findElement(By.cssSelector(".regular-price")).getText();
        assertTrue(regularPriceMain.equals(regularPriceProduct));

        String campaignPriceProduct = driver.findElement(By.cssSelector(".campaign-price")).getText();
        assertTrue(campaignPriceMain.equals(campaignPriceProduct));

        colorRegular = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        assertTrue(colorRegular.contains("102, 102, 102"));

        textDecorationRegular = driver.findElement(By.cssSelector(".regular-price")).getCssValue("text-decoration");
        assertTrue(textDecorationRegular.contains("line-through"));

        colorCampaign = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        assertTrue(colorCampaign.contains("204, 0, 0"));

        textDecorationCampaign = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-weight");
        assertTrue(textDecorationCampaign.contains("700"));

        sizePriceRegular = Integer.parseInt(driver.findElement(By.cssSelector(".regular-price")).getAttribute("offsetHeight"));
        sizePriceCampaign = Integer.parseInt(driver.findElement(By.cssSelector(".campaign-price")).getAttribute("offsetHeight"));
        assertTrue(sizePriceCampaign > sizePriceRegular);



        System.out.println(nameMain + " " + regularPriceMain + " " + campaignPriceMain + " " + colorRegular);
        System.out.println(textDecorationRegular + " " + colorCampaign + " " + textDecorationCampaign);
        System.out.println(sizePriceRegular);
        System.out.println(nameProduct);
    }
}
