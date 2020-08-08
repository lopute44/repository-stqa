import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HWLessonFour extends TestBase {
    @Test
    public void menuOfAdminPanel() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[alt='My Store']")));

        List<WebElement> itemsMenu = driver.findElements(By.cssSelector("#box-apps-menu-wrapper a"));
        int sizeListLi = itemsMenu.size();
        int sizeListUl;
        for (int i = 0; i < sizeListLi; i++) {
            itemsMenu = driver.findElements(By.cssSelector("#box-apps-menu-wrapper a"));
            itemsMenu.get(i).click();
            if (isElementPresent(By.cssSelector("#box-apps-menu-wrapper ul.docs"))) {
                itemsMenu = driver.findElements(By.cssSelector("#box-apps-menu-wrapper ul.docs li"));
                sizeListUl = itemsMenu.size();
                for (int j = 0; j < sizeListUl; j++) {
                    itemsMenu = driver.findElements(By.cssSelector("#box-apps-menu-wrapper ul.docs li"));
                    itemsMenu.get(j).click();
                }
                driver.get("http://localhost/litecart/admin/");
            }

        }
    }
}
