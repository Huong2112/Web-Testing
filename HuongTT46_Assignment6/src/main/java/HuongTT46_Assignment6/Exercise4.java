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

public class Exercise4 {
    WebDriver driver;
    @BeforeTest
    public void setup() throws AWTException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://webdevable.com/w3schools/tags/tryit5b70.html?filename=tryhtml_frame_cols");
    }
    @Test
    public void test(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // go to frame
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_a.html']")));
        // get text to compare
        WebElement frameA = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        System.out.println(frameA.getText());
        Assert.assertEquals(frameA.getText(), "Note: The frameset, frame, and noframes elements are not supported in HTML5.");

    }
    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done!");
    }
}
