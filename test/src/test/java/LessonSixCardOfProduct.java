import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class LessonSixCardOfProduct extends TestBase{

    @Test
    public void cardOfProductInAdmin(){

        String valueTable;
        String toy = "Doll Anabell";         //строковая переменная с названием игрушки, для проверки
        int counter = 0;

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        loginIn();
        driver.findElement(By.linkText("Add New Product")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[href='#tab-general']")));

        driver.findElement(By.cssSelector("[value='1'][name='status']")).click();
        driver.findElement(By.name("name[en]")).sendKeys(toy);
        driver.findElement(By.name("code")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[value='1-3']")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("10");

        File file = new File("D:/IdeaProjects/stqa/repository-stqa/test/src/test/java/images/cat.jpg");
        driver.findElement(By.cssSelector("input[name='new_images[]']")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.name("date_valid_from")).sendKeys(Keys.HOME + "20.08.2020");
        driver.findElement(By.name("date_valid_to")).sendKeys(Keys.HOME + "20.12.2020");

        driver.findElement(By.cssSelector("[href='#tab-information']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("manufacturer_id")));

        Select dropdown = new Select(driver.findElement(By.name("manufacturer_id")));
        dropdown.selectByIndex(1);

        driver.findElement(By.name("keywords")).sendKeys("doll, toy");
        driver.findElement(By.name("short_description[en]")).sendKeys("Anabel doll");

        //копирование в буфер обмена полного описания, для дальнейшей вставки в поле описания игрушки
        String myString = "LOL Surprise is a large ball inside which the girl will find one of 45 + unique dolls with clothes and accessories. The ball has 7 layers, which are disassembled, the child each time finds a surprise. ... Initially, the child does not know which of the dolls he will get, so the word surprise in the name.";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ((Clipboard) clipboard).setContents(stringSelection, null);

        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys(Keys.CONTROL + "v");

        driver.findElement(By.name("head_title[en]")).sendKeys("Anabel doll");
        driver.findElement(By.name("meta_description[en]")).sendKeys("anabell-doll");

        driver.findElement(By.cssSelector("[href='#tab-prices']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("purchase_price")));
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("20");

        dropdown = new Select(driver.findElement(By.name("purchase_price_currency_code")));
        dropdown.selectByIndex(1);

        driver.findElement(By.name("gross_prices[USD]")).clear();
        driver.findElement(By.name("gross_prices[USD]")).sendKeys("5");

        driver.findElement(By.name("gross_prices[EUR]")).clear();
        driver.findElement(By.name("gross_prices[EUR]")).sendKeys("4");

        driver.findElement(By.name("save")).click();

        //проверка наличия игрушки в списке
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");

        WebElement table = driver.findElement(By.cssSelector(".dataTable"));
        List<WebElement> rows = table.findElements(By.cssSelector("tr .row"));
        int size = rows.size();

        valueTable = rows.get(size-1).findElement(By.xpath("./td[3]")).getText();
        assertTrue(valueTable.equals(toy));
    }
}
