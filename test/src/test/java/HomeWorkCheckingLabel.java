import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class HomeWorkCheckingLabel extends TestBase{

    @Test
    public void checkingLabel(){
        driver.get("http://localhost/litecart");

        List<WebElement> itemsProduct = driver.findElements(By.cssSelector(".product"));
        for (WebElement we : itemsProduct){
            assertTrue(isLabelPresent(we, By.cssSelector("[class^=sticker]")));
            assertFalse(areLabelsPresent(we, By.cssSelector("[class^=sticker]")));
        }
    }

    /**
     * Проверка на наличие хотя бы одного стикера на элементе
     * @param we       вебэлемент в котором проверяем
     * @param locator локатор
     * @return
     */
    public boolean isLabelPresent(WebElement we, By locator) {
        try {
            we.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex){
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    /**
     * Проверка на количество стикеров на одном элементе
     * @param we
     * @param locator
     * @return
     */
    public boolean areLabelsPresent(WebElement we, By locator) {
        return we.findElements(locator).size() > 1;
    }

}
