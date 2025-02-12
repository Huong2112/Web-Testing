package Demo.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();

    }

    @AfterTest
    public void afterTest(){
        if (driver != null){
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
