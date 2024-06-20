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

public class Nest15 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://nest.botble.com/admin");;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void test(){
        //Verify login page
        WebElement title = driver.findElement(By.xpath("//input[@name='username']/parent::div//preceding-sibling::h2"));
        Assert.assertEquals(title.getText(), "Sign In Below");
        //Email
        WebElement emailLabel = driver.findElement(By.xpath("//input[@id='username']/preceding-sibling::label"));
        Assert.assertEquals(emailLabel.getText(),"Email/Username");

        WebElement emailInput = driver.findElement(By.id("username"));
        Assert.assertTrue(emailInput.isDisplayed(),"Email textbox is not display.");
        Assert.assertEquals(emailInput.getAttribute("placeholder"),"Enter your username or email address");

        //password
        WebElement passLabel = driver.findElement(By.xpath("//label[@for='password']"));
        Assert.assertEquals(passLabel.getText(),"Password\nLost your password?");

        //Lost your password
        WebElement lostPass =  driver.findElement(By.xpath("//a[@title='Forgot Password']"));
        Assert.assertEquals(lostPass.getAttribute("href"),"https://nest.botble.com/admin/password/reset");

        WebElement passInput = driver.findElement(By.id("password"));
        Assert.assertTrue(passInput.isDisplayed(),"Password textbox is not display");
        Assert.assertEquals(passInput.getAttribute("placeholder"),"Enter your password");

        //Remember me
        WebElement rememberCheckbox = driver.findElement(By.id("remember"));
        Assert.assertTrue(rememberCheckbox.isDisplayed(),"Checkbox is not display");
        WebElement rememberText = driver.findElement(By.xpath("//input[@id='remember']/following-sibling::span"));
        Assert.assertEquals(rememberText.getText(),"Remember me?");
        //Sign in button
        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(signInBtn.isDisplayed(),"Sign in button is not display");

    }

    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done");
    }

}
