package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Exercise3 {
    WebDriver driver ;
    @BeforeTest
    public void setupWeb() {
        driver = new ChromeDriver();
        driver.get("https://dokans.online/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void test() throws InterruptedException {
               //Login
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("bigbag@email.com");

        WebElement pass = driver.findElement(By.id("password"));
        pass.clear();
        pass.sendKeys("rootadmin");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(3000);

        //Relogin
        WebElement email1 = driver.findElement(By.id("email"));
        email1.clear();
        email1.sendKeys("bigbag@email.com");

        WebElement pass1 = driver.findElement(By.id("password"));
        pass1.clear();
        pass1.sendKeys("rootadmin");

        WebElement loginButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton1.click();

        //Product
        WebElement product = driver.findElement(By.xpath("//span[normalize-space()='Products']//ancestor::li"));
        product.click();

        WebElement allProducts = driver.findElement(By.linkText("All Products"));
        allProducts.click();

        //1.	Write xpath to click to Edit of first product
        WebElement editOfFirstProduct = driver.findElement(By.xpath("//tbody//tr[position() =1]//descendant::a"));
        editOfFirstProduct.click();
        // 2.	 Write locator of some element as below
        WebElement productName = driver.findElement(By.xpath("//input[@name='title']"));
        productName.clear();
        productName.sendKeys("HuongTT46");

        WebElement productSlug = driver.findElement(By.xpath("//input[@name='slug']"));
        productSlug.clear();
        productSlug.sendKeys("slug slug");

        WebElement shortDes = driver.findElement(By.xpath("//textarea[@name='excerpt']"));
        shortDes.clear();
        shortDes.sendKeys("My description here!");
        //Brands
        Select brands = new Select(driver.findElement(By.xpath("//select[@name='brand']")));
        brands.selectByVisibleText("Huawei");
        //Category
        Select categories = new Select(driver.findElement(By.xpath("//select[@name='cats[]']")));
        categories.selectByVisibleText("Electronic Accessories");
        categories.selectByVisibleText("Home & Lifestyle");
        categories.deselectByVisibleText("Groceries & Pets");


        //Feature
        Select features = new Select(driver.findElement(By.xpath("//select[@name='featured']")));
        features.selectByVisibleText("Best selling products");
    }
    @AfterTest
    public void closeWeb(){
       driver.quit();
        System.out.println("Test done!");
    }
}
