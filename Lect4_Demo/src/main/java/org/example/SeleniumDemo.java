package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://martfury.botble.com/admin/login");;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }
    @Test
    public void test(){

        //2.
        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("admin");

        WebElement pass = driver.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys("12345678");

        //3.
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        //4.
        WebElement ecommerce = driver.findElement(By.xpath("//a[@id = 'cms-plugins-ecommerce']"));
        ecommerce.click();

        WebElement products= driver.findElement(By.id("cms-plugins-ecommerce-product"));
        products.click();

        //5.

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
            System.out.println("Wait");
        }

        WebElement createButton = driver.findElement(By.xpath("//div[contains(@class ,'dropdown')]//descendant::button[contains(@class, 'btn-primary')]"));
        createButton.click();

        WebElement physicalButton = driver.findElement(By.xpath("//span[@data-action = 'physical-product']//parent::button"));
        physicalButton.click();

        //6.
        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("Product by Huong");

        Select status = new Select(driver.findElement(By.name("status")));
        status.selectByVisibleText("Pending");

        Actions actions = new Actions(driver);

        WebElement store = driver.findElement(By.xpath("//span[@id='select2--container']"));
        actions.moveToElement(store).perform();
        store.click();

        WebElement input =  driver.findElement(By.xpath("//span[contains(@class, 'select2-dropdown')]//descendant::input"));
        input.sendKeys("GoPro");
        input.sendKeys(Keys.ENTER);

        WebElement price = driver.findElement(By.id("price"));
        price.clear();
        price.sendKeys("1000");


        WebElement checkboxCategory = driver.findElement(By.xpath("//input[@value='4'][@name='categories[]']"));
        actions.moveToElement(checkboxCategory).perform();
        if (!checkboxCategory.isSelected()){
            checkboxCategory.click();
        }

        WebElement stock = driver.findElement(By.xpath("//input[@value = 'in_stock']"));
        actions.moveToElement(stock).perform();
        if (!stock.isSelected()){
            stock.click();
        }

        WebElement saveExit = driver.findElement(By.xpath("//div[@class ='card-body']//descendant::button[@value='save']"));
        actions.moveToElement(saveExit).perform();
        saveExit.click();


        //Verify
        WebElement products1= driver.findElement(By.id("cms-plugins-ecommerce-product"));
        products1.click();
        WebElement searchProduct = driver.findElement(By.xpath("//div[@class= 'table-search-input']//descendant::input"));
        searchProduct.sendKeys("Product by Huong");

        Assert.assertEquals(driver.findElement(By.xpath("//small//preceding-sibling::a")).getText(), "Product by Huong");
        Assert.assertEquals(driver.findElement(By.xpath("//small//parent::td//following-sibling::td")).getText(), "$1,000.00");
        Assert.assertEquals(driver.findElement(By.xpath("//td[@class ='   column-key-4']//descendant::span")).getText(), "In stock");

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done");
    }
}
