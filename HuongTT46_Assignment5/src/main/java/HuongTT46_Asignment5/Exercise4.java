package HuongTT46_Asignment5;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Exercise4 {
    WebDriver driver;
    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://tiki.vn/");
        Thread.sleep(1000);
    }
    @Test
    public void test(){
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("Cookie Name: " + cookie.getName() + ", Value: " + cookie.getValue());
        }
    }
    @AfterTest
    public void closeWeb(){
        //driver.quit();
        System.out.println("Test done!");
    }
}
