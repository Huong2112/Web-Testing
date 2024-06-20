package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.ref.PhantomReference;
import java.time.Duration;
import java.util.List;


public class Nest18 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://nest.botble.com/admin");;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void test() throws InterruptedException {

        WebElement emailInput = driver.findElement(By.id("username"));
        emailInput.clear();
        emailInput.sendKeys("admin");

        //password
        WebElement passInput = driver.findElement(By.id("password"));
        passInput.clear();
        passInput.sendKeys("12345678");
        //login button
        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        signInBtn.click();
        Thread.sleep(3000);

        //Ecommerce
        driver.findElement(By.xpath("//a[@title='Ecommerce']")).click();

        driver.findElement(By.id("cms-plugins-ecommerce-product")).click();
        WebElement searchBtn = driver.findElement(By.xpath("//button[normalize-space()='Filters']/following-sibling::div/descendant::input"));
        searchBtn.sendKeys("Oroweat Country Buttermilk");

        WebElement table = driver.findElement(By.id("botble-ecommerce-tables-product-table"));
        WebElement body = table.findElement(By.tagName("tbody"));
        List<WebElement> rows = body.findElements(By.tagName("tr"));
        WebElement firstElement = rows.get(0);
        firstElement.findElement(By.linkText("Oroweat Country Buttermilk Bread")).click();

//The detail product page should be display:
        WebElement name = driver.findElement(By.name("name"));
        Assert.assertEquals(name.getAttribute("value"), "Oroweat Country Buttermilk Bread");
        WebElement wad = driver.findElement(By.xpath("//input[@value='6']"));
        String checked = wad.getAttribute("checked");
        System.out.println(checked);

        WebElement tableVariant = driver.findElement(By.id("botble-ecommerce-tables-product-variation-table-15"));
        WebElement tbody = tableVariant.findElement(By.tagName("tbody"));
        List<WebElement> products = tbody.findElements(By.tagName("tr"));
        Assert.assertEquals(products.size(),2);
        String[] actual = new String[products.size()];
        int k = 0;
        for (WebElement product: products){
            k++;
            actual[k-1] = product.findElement(By.xpath("//tbody//tr[position()=" +k+"]//td[position()=4]")).getText();
            }
        System.out.println(actual);
        Assert.assertEquals(actual, new String[]{"2KG", "5KG"});

    }

    @AfterTest
    public void close(){
       // driver.quit();
        System.out.println("Test done");
    }
}
