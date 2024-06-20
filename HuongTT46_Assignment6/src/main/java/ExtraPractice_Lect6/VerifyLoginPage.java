package ExtraPractice_Lect6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyLoginPage {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento-demo.mageplaza.com/admin/admin/");

    }

    @Test
    public void test(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement username = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        Assert.assertTrue(username.isDisplayed());
        username.clear();
        username.sendKeys("mageplaza");

        WebElement password = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        Assert.assertTrue(password.isDisplayed());
        password.clear();
        password.sendKeys("demo123");


        WebElement loginBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        Assert.assertTrue(loginBtn.isDisplayed());
        loginBtn.click();

        WebElement forgotPass = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot your password?")));
        Assert.assertTrue(forgotPass.isDisplayed());

        WebElement darshboard = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Dashboard']")));
        Assert.assertTrue(darshboard.isDisplayed());


    }

}
