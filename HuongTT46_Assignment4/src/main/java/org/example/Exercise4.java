package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Exercise4 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void test(){
        //2.	Looking for “Select List Demo”
        WebElement selectList = driver.findElement(By.xpath("//div[normalize-space()='Select List Demo']/parent::div"));
        //3.	Select “Monday” in combobox
        Select days = new Select(selectList.findElement(By.id("select-demo")));
        days.selectByVisibleText("Monday");


        //4.	Verify message displayed
        WebElement message = driver.findElement(By.className("selected-value"));
        Assert.assertEquals(message.getText(), "Day selected :- Monday" );

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done!");
    }
}
