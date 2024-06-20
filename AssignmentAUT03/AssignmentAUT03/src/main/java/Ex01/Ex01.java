package Ex01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ex01 {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://dokans.online/login");
        driver.manage().window().maximize();
    }


    @Test
    public void test() throws InterruptedException {
        Actions action = new Actions(driver);

        WebElement username = driver.findElement(By.name("email"));
        username.clear();
        username.sendKeys( "bigbag@email.com");

        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("rootadmin");

        WebElement rememberMe = driver.findElement(By.id("remember-me"));
        action.moveToElement(rememberMe).click().perform();

        WebElement forgotPassword = driver.findElement(By.partialLinkText("Forgot Password?"));
        Assert.assertTrue(forgotPassword.isDisplayed());

        WebElement loginButton = driver.findElement(By.xpath("//button [@type='submit']"));
        loginButton.click();

        Thread.sleep(3000);

        WebElement username1 = driver.findElement(By.name("email"));
        username1.clear();
        username1.sendKeys( "bigbag@email.com");

        WebElement password1 = driver.findElement(By.name("password"));
        password1.clear();
        password1.sendKeys("rootadmin");

        WebElement loginButton1 = driver.findElement(By.xpath("//button [@type='submit']"));
        loginButton1.click();

    }
}
