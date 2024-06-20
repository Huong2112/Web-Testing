package HuongTT46_Assignment6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;


public class Exercise3 {
    WebDriver driver;

    @BeforeTest
    public void setup() throws AWTException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // go to frame
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Iframe Example']")));
        // get text to compare
        WebElement frameText = driver.findElement(By.tagName("h1"));
        String text = frameText.getText();
        System.out.println(text);
        Assert.assertEquals(text, "This page is displayed in an iframe");
    }

    @AfterTest
    public void close() {
        driver.quit();
        System.out.println("Test done!");
    }
}
