import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class HomeWorkCountries extends TestBase {
    @Test
    public void isCheckingCountries(){
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        loginIn();

        WebElement table = driver.findElement(By.cssSelector(".dataTable tbody"));    //получаем таблицу
        List<WebElement> rows = table.findElements(By.cssSelector("tr .row"));        //из таблицы получаем список строк
        int size = rows.size();                                                       //размер списка
        int sizeZone;
        String firstCountry;
        String secondCountry;
        WebElement zone;
        
        for (int i = 0; i < size; i++){                                               //цикл по списку
            if (i < size - 1){                                                        //проверяем, что не последняя строка, что бы не выйти за пределы списка
                firstCountry = rows.get(i).findElement(By.xpath("./td[5]")).getText();  //присваеваем значение первой страны
                secondCountry = rows.get(i + 1).findElement(By.xpath("./td[5]")).getText();  //значение второй страны
                assertTrue(isCompareToString(firstCountry, secondCountry));                  //с помощью метода сравниваем страны, что онв алфавитном порядке
            }

            zone = rows.get(i).findElement(By.xpath("./td[6]"));                              //получаем количество зон
            if (Integer.parseInt(zone.getText()) > 0){                                        //проверяем, что это количество больше 0
                rows.get(i).findElement(By.cssSelector("td:nth-child(5) a")).click();         // кликаем на страну
                table = driver.findElement(By.cssSelector(".dataTable tbody"));               //обновляем элемент таблицы
                rows = table.findElements(By.cssSelector("tr"));                              //обновляем список строк
                sizeZone = rows.size();                                                       //получаем размер списка

                for (int j = 1; j < sizeZone - 2; j++) {                                      //цикл по списку, как и на странице стран
                    firstCountry = rows.get(j).findElement(By.xpath("./td[3]")).getText();       //получаем значение первой зоны
                    secondCountry = rows.get(j + 1).findElement(By.xpath("./td[3]")).getText();  //получаем значение второй зоны
                    assertTrue(isCompareToString(firstCountry, secondCountry));
                }

                driver.findElement(By.xpath("//span[.='Countries']")).click();                //возвращаемся на страницу стран
                table = driver.findElement(By.cssSelector(".dataTable tbody"));               //обновляем таблицу
                rows = table.findElements(By.cssSelector("tr .row"));                         //обновляем список
            }
        }
    }

    @Test
    public void isCheckingGeoZone(){
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        loginIn();

        WebElement table = driver.findElement(By.cssSelector(".dataTable"));    //получаем таблицу
        List<WebElement> rows = table.findElements(By.cssSelector("tr .row"));        //из таблицы получаем список строк
        int size = rows.size();                                                       //размер списка
        int sizeZone;
        String firstZone;
        String secondZone;
        WebElement zone;

        for (int i = 0; i < size; i++){                                               //цикл по списку
            rows.get(i).findElement(By.cssSelector("td:nth-child(3) a")).click();             //кликаем на страну в списке
            table = driver.findElement(By.cssSelector(".dataTable"));                         //в таблицу записываем таблицу с зонами
            rows = table.findElements(By.cssSelector("tr td:nth-child(3) [selected]"));       //обновляем список строк из таблицы с зонами
            sizeZone = rows.size();

            for (int j = 1; j < sizeZone - 2; j=j+2){                                         //цикл по строкам таблицы
                firstZone = rows.get(j).getAttribute("textContent");                 //получаем значение первой зоны
                secondZone = rows.get(j + 2).getAttribute("textContent");            //получаем значение второй зоны
                isCompareToString(firstZone, secondZone);                               //сравниваем значения
            }

            driver.findElement(By.xpath("//span[.='Geo Zones']")).click();                //возвращаемся на страницу стран
            table = driver.findElement(By.cssSelector(".dataTable"));                     //возвращаем таблицу со странвами
            rows = table.findElements(By.cssSelector("tr .row"));                         //обновляем строки
        }
    }

    /**
     * Сравнение строк в алфавитном порядке
     * @param firstCountry первая страна
     * @param secondCountry вторая страна
     * @return
     */
    public boolean isCompareToString(String firstCountry, String secondCountry){
        return secondCountry.compareTo(firstCountry) >= 0;
    }
}
