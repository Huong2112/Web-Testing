package HuongTT46_Asignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise3 {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/simple_context_menu.html ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void test() throws IOException, InterruptedException, AWTException {
        Actions builder = new Actions(driver);
        WebElement rightclick = driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
        Assert.assertTrue(rightclick.isDisplayed());
        builder.contextClick(rightclick).perform();

        WebElement edit = driver.findElement(By.xpath("//div[@id='context-menu-layer']//following-sibling::ul//descendant::li[position()=1]"));
        edit.click();
        Thread.sleep(1000);

        Robot robot= new Robot();
        Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage tempImg = robot.createScreenCapture(screen);
        ImageIO.write(tempImg,"png", new File("exercise3.png"));


    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
        System.out.println("Test done!");
    }
}
