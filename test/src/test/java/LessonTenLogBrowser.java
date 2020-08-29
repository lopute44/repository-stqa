import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LessonTenLogBrowser extends TestBase{

    @Test
    public void checkingLogOfBrowser(){
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        System.out.println(driver.manage().logs().getAvailableLogTypes());
        loginIn();
        driver.findElement(By.xpath("//a[.='Rubber Ducks']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Blue Duck']"))));
        List<WebElement> itemsOfProduct = driver.findElements(By.cssSelector(".dataTable tr.row td:nth-child(3) > a"));

        for (int i = 1; i < itemsOfProduct.size(); i++){
            itemsOfProduct.get(i).click();
            assertTrue(driver.manage().logs().get("browser").getAll().size() == 0);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            itemsOfProduct = driver.findElements(By.cssSelector(".dataTable tr.row td:nth-child(3) > a"));
        }
    }
}
