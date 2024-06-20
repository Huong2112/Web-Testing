package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Exercise2 {
    WebDriver driver;
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

        //Login
        WebElement email1 = driver.findElement(By.id("email"));
        email1.clear();
        email1.sendKeys("bigbag@email.com");

        WebElement pass1 = driver.findElement(By.id("password"));
        pass1.clear();
        pass1.sendKeys("rootadmin");

        WebElement loginButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton1.click();


        WebElement order= driver.findElement(By.xpath("//span[normalize-space()='Orders']//ancestor::li"));
        order.click();


        WebElement allOders = driver.findElement(By.linkText("All Orders"));
        allOders.click();

        //1.	Write xpath of order total, payment status base on order name.
        List<WebElement> orderTotalAndPaymentStatus = driver.findElements(By.xpath("//a[normalize-space()='bigbag704']//parent::td//following-sibling::td[position()>2 and position()<5]"));
        // 2.	 Write xpath to get 4 first order in Orders table
        List<WebElement> first4Orders = driver.findElements(By.xpath("//tbody//descendant::tr[position()<5]"));


    }

    @AfterTest
    public void closeWeb(){
        driver.quit();
        System.out.println("Test done!");
    }
}
