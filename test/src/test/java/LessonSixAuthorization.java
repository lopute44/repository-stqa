import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class LessonSixAuthorization extends TestBase{
    public String password = "123456";
    public String email;

    @Test
    public void authorization(){
        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath("//a[.='New customers click here']")).click();

        driver.findElement(By.name("tax_id")).sendKeys("123456");
        driver.findElement(By.name("company")).sendKeys("QA");
        driver.findElement(By.name("firstname")).sendKeys("Evgeniya");
        driver.findElement(By.name("lastname")).sendKeys("Ilina");
        driver.findElement(By.name("address1")).sendKeys("Chicago, Firststreen, 21");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("Chicago");

        Select dropdown = new Select(driver.findElement(By.name("country_code")));
        dropdown.selectByVisibleText("United States");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("select[name='zone_code']")));
        dropdown = new Select((driver.findElement(By.cssSelector("select[name='zone_code']"))));
        dropdown.selectByVisibleText("Colorado");

        Random random = new Random();
        int n = random.nextInt(100) + 1;
        email = "ilina" + n + "@mail.ru";
        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("phone")).sendKeys("+1234567890");
        driver.findElement(By.name("newsletter")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);

        driver.findElement(By.name("create_account")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[alt='My Store']")));
        driver.findElement(By.cssSelector("#box-account [href = 'http://localhost/litecart/en/logout']")).click();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[alt='My Store']")));
        driver.findElement(By.cssSelector("#box-account [href = 'http://localhost/litecart/en/logout']")).click();
    }
}
