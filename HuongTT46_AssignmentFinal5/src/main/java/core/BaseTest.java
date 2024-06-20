package core;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MenuPage;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    private WebDriver driver;

    @Parameters({"platform", "browser"})
    @BeforeTest
    public void beforeTest(String platform, String browser) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if (platform.equals("Windows")){
            desiredCapabilities.setPlatform(Platform.WINDOWS);
        }
        if (browser.equals("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);

        }

        if (browser.equals("MicrosoftEdge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            //edgeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
            desiredCapabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);

        }

        if (browser.equals("chrome")){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }
        desiredCapabilities.setBrowserName(browser);
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);

    }


    @AfterTest
    public void afterTest() throws InterruptedException {
        if (driver != null){
            Thread.sleep(1000);
            driver.quit();
        }
    }

    @AfterMethod ()
    public void afterMethod(){
        LoginPage loginPage = new LoginPage(driver);
        try {
            MenuPage menuPage = new MenuPage(driver);
            menuPage.logOut();
        }catch (Exception e){
            System.out.println("Manual logout please!");
        }
    }

//    @AfterMethod ()
//    public void afterMethod() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//            MenuPage menuPage = new MenuPage(driver);
//            menuPage.logOut();
//    }

    public WebDriver getDriver() {
        return driver;
    }
}
