package HuongTT46_Assignment6;

import org.openqa.selenium.Alert;
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

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Exercise1 {
    WebDriver driver;
    Robot robot;
    Rectangle screenSize;
    WebDriverWait webDriverWait;


    @BeforeTest
    public void setup() throws AWTException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        robot = new Robot();
        screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
       webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void testScriptAlertBox() throws IOException, InterruptedException {
        //4.	In JavaScript Alert Box, click “Click Me” and Capture the alert’s text.
        WebElement clickMeBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Java Script Alert Box']/parent::div/descendant::button[normalize-space()='Click me!']")));
        clickMeBtn.click();

        Thread.sleep(2000);

        BufferedImage screenCapture = robot.createScreenCapture(screenSize);
        ImageIO.write(screenCapture,"png", new File("test1.png"));

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test (priority = 2)
    public void testConfirmBox() throws IOException, InterruptedException {
        //1.	In JavaScript Confirm Box, click “Click Me”.
        WebElement confirmClickMe = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Java Script Confirm Box']/following-sibling::div/descendant::button")));
        confirmClickMe.click();
        Thread.sleep(2000);

        webDriverWait.until(ExpectedConditions.alertIsPresent());
        BufferedImage confirmBoxScr = robot.createScreenCapture(screenSize);
        ImageIO.write(confirmBoxScr,"png", new File("confirmBox.png"));
        //2.	Get the alert’s text and click OK button
        Alert alert = driver.switchTo().alert();
       String alertsText =  alert.getText();
        System.out.println(alertsText);
        alert.accept();

        WebElement expected = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirm-demo")));
        Assert.assertEquals(expected.getText(), "You pressed OK");

    }

    @Test (priority = 3)
    public void testPromptBox() throws IOException, InterruptedException {
        WebElement promptBoxBtn = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Click for Prompt Box']")));
        promptBoxBtn.click();

        Thread.sleep(2000);

        webDriverWait.until(ExpectedConditions.alertIsPresent());
        BufferedImage promptBoxImg = robot.createScreenCapture(screenSize);
        ImageIO.write(promptBoxImg,"png", new File("promptBox.png"));

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Tran Thi Huong");
        alert.accept();

        WebElement promptDemo = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("prompt-demo")));
        System.out.println(promptDemo.getText());
        Assert.assertEquals(promptDemo.getText(),"You have entered 'Tran Thi Huong' !");

    }

    @AfterTest
    public void close(){
        driver.quit();
        System.out.println("Test done!");
    }
}
