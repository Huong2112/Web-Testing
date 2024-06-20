package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Exercise3 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html ");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void test(){
       // 2.	Looking for “Group Radio Buttons Demo”
        WebElement groupDemo = driver.findElement(By.xpath("//div[normalize-space()='Group Radio Buttons Demo']//parent::div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(groupDemo).perform();
        //3,4
        List<WebElement> radioGroup = groupDemo.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement option : radioGroup){
            if (option.getAttribute("value").equals("Male") || option.getAttribute("value").equals("5 - 15")){
                if (!option.isSelected()){
                    option.click();
                }
            }
        }

        WebElement getValueBtn = driver.findElement(By.xpath("//input[@value ='15 - 50']//parent::label//parent::div//following-sibling::button"));
        getValueBtn.click();

        WebElement text = driver.findElement(By.className("groupradiobutton"));
        Assert.assertEquals(text.getText(),"Sex : Male\nAge group: 5 - 15");

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done!");
    }
}
