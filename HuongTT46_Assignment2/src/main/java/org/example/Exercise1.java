package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Exercise1 {
    WebDriver driver = new ChromeDriver();
    @Test
    public void test(){

        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().window().maximize();

        //Verify display
        WebElement email = driver.findElement(By.name("email"));
        Assert.assertTrue(email.isDisplayed(),"Email is not displayed.");

        WebElement password = driver.findElement(By.name("password"));
        Assert.assertTrue(password.isDisplayed(), "Password is not displayed.");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed.");

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
        System.out.println("Test done!");
    }
}
