package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise3 {
    WebDriver driver = new ChromeDriver();
    @Test
    public void test(){

        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Login
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();


        WebElement catalog = driver.findElement(By.xpath("//span[normalize-space() = 'Catalog']"));
        if (catalog.isDisplayed()){
            catalog.click();
            System.out.println("Catalog is clicked!");

        }

        WebElement productUnits = driver.findElement(By.xpath("//span[normalize-space() = 'Product Units']"));
        if (productUnits.isDisplayed()){
            productUnits.click();
            System.out.println("Product unit is clicked!");
        }

        //Verify display
        WebElement id = driver.findElement(By.xpath("//th[normalize-space() = 'ID']"));
        Assert.assertTrue(id.isDisplayed(),"ID is not displayed.");

        WebElement name = driver.findElement(By.xpath("//th[normalize-space() = 'Name']"));
        Assert.assertTrue(name.isDisplayed(),"Name is not display.");

        WebElement status = driver.findElement(By.xpath("//th[normalize-space() = 'Status']"));
        Assert.assertTrue(status.isDisplayed(),"Status is not display.");

        WebElement action = driver.findElement(By.xpath("//th[normalize-space() = 'Action']"));
        Assert.assertTrue(action.isDisplayed(), "Action is not display.");

    }

    @AfterTest
    public void test1(){
        driver.quit();
        System.out.println("Test done!");
    }

}
