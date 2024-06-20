package Lect5_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(button).perform();
        actions.contextClick();

        driver.quit();
    }
}
