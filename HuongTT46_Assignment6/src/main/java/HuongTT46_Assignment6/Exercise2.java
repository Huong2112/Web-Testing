package HuongTT46_Assignment6;

import org.checkerframework.checker.guieffect.qual.AlwaysSafe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class Exercise2 {
    WebDriver driver;

    @BeforeTest
    public void setup() throws AWTException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/window-popup-modal-demo.html ");

    }

    @Test
    public void test() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement twisterBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Follow On Twitter']")));
        twisterBtn.click();
        String parentID = driver.getWindowHandle();

        for (String windowId : driver.getWindowHandles()) {
            if (!windowId.equals(parentID)) {
                driver.switchTo().window(windowId);
                break;
            }
        }

        try {
            webDriverWait.until(ExpectedConditions.titleContains("Selenium"));
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        String title = driver.getTitle();
        if (title != null && !title.isEmpty()) {
            System.out.println(title);
        } else {
            System.out.println("Failed to get title.");
        }
        driver.close();
        driver.switchTo().window(parentID);

        WebElement facebookBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Follow @seleniumeasy on Facebook']")));
        facebookBtn.click();
        for (String windowId : driver.getWindowHandles()) {
            if (!windowId.equals(parentID)) {
                driver.switchTo().window(windowId);
                break;

            }
        }
        try {
            webDriverWait.until(ExpectedConditions.titleContains("Selenium"));
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
        String title1 = driver.getTitle();
        if (title1 != null && !title1.isEmpty()) {
            System.out.println(title1);
        } else {
            System.out.println("Failed to get title.");
        }
        driver.close();
        driver.switchTo().window(parentID);

    }

    @AfterTest
    public void close() {
        driver.quit();
        System.out.println("Test done!");
    }
}
