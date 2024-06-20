package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumDemo {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://martfury.botble.com/admin/login");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));
        username.clear();
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("12345678");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        loginButton.click();

        driver.quit();
    }
}
