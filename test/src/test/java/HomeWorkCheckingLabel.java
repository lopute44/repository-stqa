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

        checkingLabelOnElement(By.cssSelector("#box-most-popular li"), By.cssSelector("#box-most-popular li [class^=sticker]"));  //проверяем блок популярные предложения
        checkingLabelOnElement(By.cssSelector("#box-campaigns li"), By.cssSelector("#box-campaigns li [class^=sticker]"));               //проверяем блок акций
        checkingLabelOnElement(By.cssSelector("#box-latest-products li"), By.cssSelector("#box-latest-products li [class^=sticker]"));   //проверяем блок с отсатками

    }

    /**
     * Проверка контейнера со списком предложений на наличие стикеров
     * @param locator  локатор контейнера
     * @param locatorOfLabel локатор стикера в контейнере
     */
    public void checkingLabelOnElement(By locator, By locatorOfLabel){
        List<WebElement> itemsProduct = driver.findElements(locator);
        for (WebElement we : itemsProduct){
            assertTrue(isLabelPresent(we, locatorOfLabel));
            assertFalse(areLabelsPresent(we, locatorOfLabel));
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
