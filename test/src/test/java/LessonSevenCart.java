import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class LessonSevenCart extends TestBase {

    @Test
    public void testForCart() {
        driver.get("http://localhost/litecart/");
        List<WebElement> listOfProduct = driver.findElements(By.cssSelector(".content #box-most-popular li"));
        for (int i = 0; i < 3; i++){
            addToCard(listOfProduct.get(i));
            listOfProduct = driver.findElements(By.cssSelector(".content #box-most-popular li"));
        }

        driver.findElement(By.cssSelector(".link[href='http://localhost/litecart/en/checkout']")).click();
        List<WebElement> itemOfTable = driver.findElements(By.cssSelector(".dataTable tr td.item"));

        for (int j = itemOfTable.size() - 1; j >= 0; j--) {
            driver.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(itemOfTable.get(j)));
        }

    }
    
    public void addToCard(WebElement element) {
        element.click();
        int quantityInt = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText());
        driver.findElement(By.name("add_cart_product")).click();
        String quantityStr = Integer.toString(quantityInt+1);
        wait.until(textToBePresentInElement(driver.findElement(By.cssSelector("span.quantity")), quantityStr));
        driver.get("http://localhost/litecart/");
    }
}
