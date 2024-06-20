package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateBrands {
    WebDriver driver = new ChromeDriver();
    @Test
    public void createBrandTest() {
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
        WebElement ecommerce = driver.findElement(By.id("cms-plugins-ecommerce"));
        ecommerce.click();

        WebElement brands = driver.findElement(By.id("cms-plugins-brands"));
        action.moveToElement(brands).perform();
        brands.click();

        //5.
        WebElement createButton = driver.findElement(By.xpath("//span[@data-action ='create']//parent::button"));
        createButton.click();

        //6.

        WebElement name = driver.findElement(By.name("name"));
        name.clear();
        name.sendKeys("Auto Demo");

        //7.
        WebElement saveExitButton = driver.findElement(By.xpath("//div[@class ='card-body']//descendant::button[@value='save']"));
        saveExitButton.click();


    }

    @AfterTest
    public void closeWeb(){
        driver.quit();
        System.out.println("Test done!");
    }
}
