import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

        clickOnItemOfMenu(By.xpath("//a[contains(., 'Appearence')]"), "Template");
        clickOnItemOfMenu(By.id("doc-template"), "Template");
        clickOnItemOfMenu(By.id("doc-logotype"), "Logotype");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Catalog')]"), "Catalog");
        clickOnItemOfMenu(By.id("doc-catalog"), "Catalog");
        clickOnItemOfMenu(By.id("doc-product_groups"), "Product Groups");
        clickOnItemOfMenu(By.id("doc-option_groups"), "Option Groups");
        clickOnItemOfMenu(By.id("doc-manufacturers"), "Manufacturers");
        clickOnItemOfMenu(By.id("doc-suppliers"), "Suppliers");
        clickOnItemOfMenu(By.id("doc-delivery_statuses"), "Delivery Statuses");
        clickOnItemOfMenu(By.id("doc-sold_out_statuses"), "Sold Out Statuses");
        clickOnItemOfMenu(By.id("doc-quantity_units"), "Quantity Units");
        clickOnItemOfMenu(By.id("doc-csv"), "CSV Import/Export");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Countries')]"), "Countries");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Currencies')]"), "Currencies");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Geo Zones')]"), "Geo Zones");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Languages')]"), "Languages");
        clickOnItemOfMenu(By.id("doc-languages"), "Languages");
        clickOnItemOfMenu(By.id("doc-storage_encoding"), "Storage Encoding");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Modules')]"), "Job Modules");
        clickOnItemOfMenu(By.id("doc-jobs"), "Job Modules");
        clickOnItemOfMenu(By.id("doc-customer"), "Customer Modules");
        clickOnItemOfMenu(By.id("doc-shipping"), "Shipping Modules");
        clickOnItemOfMenu(By.id("doc-payment"), "Payment Modules");
        clickOnItemOfMenu(By.id("doc-order_total"), "Order Total Modules");
        clickOnItemOfMenu(By.id("doc-order_success"), "Order Success Modules");
        clickOnItemOfMenu(By.id("doc-order_action"), "Order Action Modules");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Orders')]"), "Orders");
        clickOnItemOfMenu(By.id("doc-orders"), "Orders");
        clickOnItemOfMenu(By.id("doc-order_statuses"), "Order Statuses");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Pages')]"), "Pages");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Reports')]"), "Monthly Sales");
        clickOnItemOfMenu(By.id("doc-monthly_sales"), "Monthly Sales");
        clickOnItemOfMenu(By.id("doc-most_sold_products"), "Most Sold Products");
        clickOnItemOfMenu(By.id("doc-most_shopping_customers"), "Most Shopping Customers");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Settings')]"), "Settings");
        clickOnItemOfMenu(By.id("doc-store_info"), "Settings");
        clickOnItemOfMenu(By.id("doc-defaults"), "Settings");
        clickOnItemOfMenu(By.id("doc-general"), "Settings");
        clickOnItemOfMenu(By.id("doc-listings"), "Settings");
        clickOnItemOfMenu(By.id("doc-images"), "Settings");
        clickOnItemOfMenu(By.id("doc-checkout"), "Settings");
        clickOnItemOfMenu(By.id("doc-advanced"), "Settings");
        clickOnItemOfMenu(By.id("doc-security"), "Settings");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Slides')]"), "Slides");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Tax')]"), "Tax Classes");
        clickOnItemOfMenu(By.id("doc-tax_classes"), "Tax Classes");
        clickOnItemOfMenu(By.id("doc-tax_rates"), "Tax Rates");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Translations')]"), "Search Translations");
        clickOnItemOfMenu(By.id("doc-search"), "Search Translations");
        clickOnItemOfMenu(By.id("doc-scan"), "Scan Files For Translations");
        clickOnItemOfMenu(By.id("doc-csv"), "CSV Import/Export");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'Users')]"), "Users");
        clickOnItemOfMenu(By.xpath("//a[contains(., 'vQmods')]"), "vQmods");
        clickOnItemOfMenu(By.id("doc-vqmods"), "vQmods");
    }
}
