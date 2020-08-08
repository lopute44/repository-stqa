import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertFalse;

public class TestLessonFour extends TestBase {

    //@Test
    public void MyTest(){
        driver.get("https://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        assertFalse(isElementPresent(By.xpath("//div[")));
    }
}
