package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise1 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void test(){
        WebElement userInput = driver.findElement(By.xpath("//input[@id='user-message']"));
        userInput.sendKeys("Automation Tester");

        WebElement showMessageBtn = driver.findElement(By.xpath("//form[@id='get-input']//descendant::button"));
        showMessageBtn.click();

        // Verify message display
        WebElement message = driver.findElement(By.id("display"));
        Assert.assertEquals(message.getText(),"Automation Tester");
    }

    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done!");
    }
}
