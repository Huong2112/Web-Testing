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

public class Exercise2 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-checkbox-demo.html  ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void test(){
        //2.	Looking for “Signle Checkbox Demo”
        WebElement signleCheckBox = driver.findElement(By.xpath("//div[normalize-space()='Single Checkbox Demo']/parent::div"));
        //3.	Click “Click on this check box” check box
        WebElement checkbox = signleCheckBox.findElement(By.id("isAgeSelected"));
        if (!checkbox.isSelected()){
            checkbox.click();
        }

        //4.	Verify message display
        WebElement message = driver.findElement(By.id("txtAge"));
        Assert.assertEquals(message.getText(), "Success - Check box is checked");

    }
    @AfterTest
    public void close(){
       driver.quit();
        System.out.println("Test done!");
    }

}
