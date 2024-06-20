package Lect5_Demo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.security.auth.Destroyable;
import java.io.File;
import java.io.IOException;

public class CaptureScreen {
    @Test
    public void test() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://martfury.botble.com/admin/login");
        Thread.sleep(3000);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("captureScreenDemo.png"));
    }
}
