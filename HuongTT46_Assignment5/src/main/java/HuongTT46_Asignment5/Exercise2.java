package HuongTT46_Asignment5;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise2 {
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
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Double-Click Me To See Alert']"));
        Assert.assertTrue(button.isDisplayed());
        builder.doubleClick(button).perform();
        Thread.sleep(1000);


        //Capture screen
        Robot robot = new Robot();
        Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage tempImg = robot.createScreenCapture(rectangle);
        ImageIO.write(tempImg, "png", new File("excercise2.png"));

        Thread.sleep(5000);

    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
        System.out.println("Test done!");
    }
}
