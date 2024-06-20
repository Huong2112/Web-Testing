package org.example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class Login {
    WebDriver driver = new ChromeDriver();
    @Test
    public void test(){
        driver.get("https://rawal-admin.themes-coder.net/admin/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        //
    }

    @AfterTest
    public void test2(){
        //driver.quit();
        System.out.println("Test done!");
    }

}
