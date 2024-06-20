package Lect6_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WindowDemo {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String windowParentId = driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tabButton"))).click();

        for (String windowId : driver.getWindowHandles()){
            driver.switchTo().window(windowId);
            String text = "";
            try {
                text = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(text);
            }catch (Exception e){

            }

            if (!text.equals("")){
                break;
            }
        }

        driver.switchTo().window(windowParentId);
        driver.quit();
    }
}
