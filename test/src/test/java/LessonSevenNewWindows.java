import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class LessonSevenNewWindows extends TestBase{

    @Test
    public void checkingNewWindows(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.manage().window().fullscreen();
        loginIn();

        driver.findElement(By.cssSelector(".dataTable tr:nth-of-type(2) > td:nth-of-type(5) > a")).click();
        List<WebElement> listLinkToWindow = driver.findElements(By.cssSelector("#content table tr .fa"));
        String originalWindow = driver.getWindowHandle();
        Set<String> existingWindows = driver.getWindowHandles();

        for (WebElement we : listLinkToWindow) {
            wait.until(ExpectedConditions.visibilityOf(we));
            we.click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
            listLinkToWindow = driver.findElements(By.cssSelector("#content table tr .fa"));
        }

    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows){
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}
