package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise1 {
    WebDriver driver = new ChromeDriver();
    @Test
    public void locatorTest(){
        driver.get("https://dokans.online/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Actions action = new Actions(driver);

        //Verify email
        WebElement emailLabel = driver.findElement(By.xpath("//input[@id='email']/preceding-sibling::label"));
        Assert.assertTrue(emailLabel.isDisplayed(),"Email label is not display");
        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(email.isDisplayed(),"Email input is not displayed.");


        //Verify password
        WebElement passLabel = driver.findElement(By.xpath("//label[@for='password']"));
        Assert.assertTrue(passLabel.isDisplayed(),"Password label is not displayed.");

        WebElement forget = driver.findElement(By.linkText("Forgot Password?"));
        Assert.assertTrue(forget.isDisplayed(),"Forgot password is not displayed.");

        WebElement input = driver.findElement(By.id("password"));
        Assert.assertTrue(input.isDisplayed(), "Password input is not display");

        //Verify remember me
        WebElement rememberMe = driver.findElement(By.xpath("//input[@id='remember-me']//parent::div"));
        Assert.assertTrue(rememberMe.isDisplayed(),"Remember me check box is not displayed.");


        //Verify login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(),"Login button is not displayed.");

    }

    @AfterTest
    public void closeWeb(){
        driver.quit();
        System.out.println("Test done!");
    }
}
