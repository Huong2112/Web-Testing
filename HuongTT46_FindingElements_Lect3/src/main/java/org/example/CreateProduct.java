package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class CreateProduct {
    WebDriver driver = new ChromeDriver();
    @Test
    public void testCreateProductSuccessfully(){
        //1.
        driver.manage().window().maximize();
        driver.get("https://martfury.botble.com/admin");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions action = new Actions(driver);

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
        name.sendKeys("Auto Demo");

        WebElement store = driver.findElement(By.xpath("//span[normalize-space()='Select a store...']"));
        action.moveToElement(store).perform();
        store.click();
        WebElement gopro = driver.findElement(By.xpath("//li[normalize-space()='GoPro']"));
        gopro.click();

        WebElement homeAudit = driver.findElement(By.xpath("//input[@name = 'categories[]'][@value='4']"));
        action.moveToElement(homeAudit).perform();
        if (!homeAudit.isSelected()){
            System.out.println("it is not click");
            homeAudit.click();
        }

        WebElement price = driver.findElement(By.id("price"));
        price.clear();
        price.sendKeys("1000");

    }

    @AfterTest
    public void closeWeb(){
        driver.quit();
        System.out.println("Test done!");
    }
}
