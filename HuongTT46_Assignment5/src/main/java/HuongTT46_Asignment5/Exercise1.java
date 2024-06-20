package HuongTT46_Asignment5;


import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise1 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void test(){

        Actions builder = new Actions(driver);
        WebElement destination = driver.findElement(By.xpath("//ol[@id='amt7']/parent::div"));
        WebElement source= driver.findElement(By.xpath("//li[@data-id='2']"));
        builder.dragAndDrop(source, destination).perform();

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();
        System.out.println("Test done!");
    }
}
