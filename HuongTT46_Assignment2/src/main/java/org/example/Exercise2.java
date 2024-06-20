package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Exercise2 {

    WebDriver driver = new ChromeDriver();
    @Test
    public void test(){

        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //Login
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("admin@email.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        //Verify display
        WebElement dashboard = driver.findElement(By.xpath("//span[normalize-space() = 'Dashboard']"));
        Assert.assertTrue(dashboard.isDisplayed(), "Dashboard is not displayed.");

        WebElement media = driver.findElement(By.xpath("//span[normalize-space() = 'Media']"));
        Assert.assertTrue(media.isDisplayed(), "Media is not displayed.");

        WebElement catalog = driver.findElement(By.xpath("//span[normalize-space() = 'Catalog']"));
        Assert.assertTrue(catalog.isDisplayed(), "Catalog is not display. ");

        WebElement stock_inventory = driver.findElement(By.xpath("//span[normalize-space() = 'Stock / Inventory']"));
        Assert.assertTrue(stock_inventory.isDisplayed(), "Stock / Inventory is not display. ");

        WebElement quotation = driver.findElement(By.xpath("//span[normalize-space() = 'Quotations']"));
        Assert.assertTrue(quotation.isDisplayed(), "Quotations is not display. ");

        WebElement orders = driver.findElement(By.xpath("//div[@class = 'card-body']/h3[normalize-space()='Orders']"));
        Assert.assertTrue(orders.isDisplayed(), "Order Panel is not display. ");

        WebElement products = driver.findElement(By.xpath("//div[@class = 'card-body']/h3[normalize-space()='Products']"));
        Assert.assertTrue(products.isDisplayed(), "Products Panel is not display. ");

        WebElement users = driver.findElement(By.xpath("//div[@class = 'card-body']/h3[normalize-space()='Users']"));
        Assert.assertTrue(users.isDisplayed(), "Order Panel is not display. ");

        WebElement sales = driver.findElement(By.xpath("//div[@class = 'card-body']/h3[normalize-space()='Sales']"));
        Assert.assertTrue(sales.isDisplayed(), "Sales Panel is not display. ");

    }

    @AfterTest
    public void test1(){
        driver.quit();
        System.out.println("Test done!");
    }


}
