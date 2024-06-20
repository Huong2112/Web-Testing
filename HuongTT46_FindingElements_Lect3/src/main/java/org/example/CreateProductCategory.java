package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateProductCategory {
    WebDriver driver = new ChromeDriver();
    @Test
    public void createProductCategoryTest(){
        //1.
        driver.get("https://martfury.botble.com/admin");
        driver.manage().window().maximize();
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

        WebElement productCategories = driver.findElement(By.id("cms-plugins-product-categories"));
        productCategories.click();

        //5.
        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("Tran Thi Huong");

        WebElement parent = driver.findElement(By.id("select2--container"));
        parent.click();

        WebElement electronics = driver.findElement(By.xpath("//li[normalize-space()='Electronics']"));
        electronics.click();

        WebElement status = driver.findElement(By.xpath("//select[@name ='status']"));
        action.moveToElement(status).perform();
        status.click();

        WebElement pub = driver.findElement(By.xpath("//option[@value='published']"));
        pub.click();

        //6.
        WebElement save = driver.findElement(By.xpath("//div[@class ='card-body']//descendant::button[@value='apply']"));
        action.moveToElement(save).perform();
        save.click();


    }

    @AfterTest
    public void closeWeb(){
        //driver.quit();
        System.out.println("Test done!");

    }
}
